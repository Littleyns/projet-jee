const initializeFavoriteIcon = async (isbn) => {
	var favorite = $("#favorite");
	$.ajax({
		type: 'POST',
		url: "/Services/book.php?action=isFavorite",
		data: { isbn: isbn + "" },
		success: (d) => {
			if (d.trim() == "true") {
				favorite.prop("checked", true);
			}
		},
		async: false
	});

}


let popup = document.getElementById('popup_container')
let closeBtn = document.getElementsByClassName('close')[0]
let overlay = document.getElementsByClassName('overlay')[0]


//une fonction qui permet de fermer le popup
const closePopup = () => {

	overlay.style.visibility = 'hidden';
	document.getElementById('popup_container').style.visibility = 'hidden';
	overlay.style.opacity = '0';
	document.getElementById("commentaryArea").innerHTML = "";
	console.log("closeee popup");
	// window.location.href=""; a enlever pour essayer la bdd 
}
//

//close popup on click on close btn

// on click on favorite button (heart)
$('#favorite').click(() => {
	checked = $('#favorite').prop('checked')
	console.log(checked)
	if (checked) {
		$.post("/Services/book.php?action=addFavorite", { isbn: isbn.value + "" }).done((d) => {
			$("#success-favorites-add").fadeTo(2000, 500).slideUp(500, function() {
				$("#success-favorites-add").slideUp(500);
			});
		});
	} else {
		$.post("/Services/book.php?action=removeFavorite", { isbn: isbn.value + "" }).done((d) => {
			$("#success-favorites-remove").fadeTo(2000, 500).slideUp(500, function() {
				$("#success-favorites-remove").slideUp(500);
			});
		})
	}
})

function reinitializeCommentaryAndRate() {
	document.getElementById("commentaire").value = "";
	document.querySelectorAll(".rating>input").forEach(r => r.checked = false)
}
var spinnerLoadingHtml = '<div id="loading-replies"><div class="spinner-border" role="status"><span class="sr-only">Loading...</span></div></div>'
let commentaires = document.getElementById('commentaryArea');





const popupCloseListening = () => {
	let closeBtn = document.getElementsByClassName('close')[0]
	var overlay = document.getElementsByClassName('overlay')[0]

	closeBtn.addEventListener("click", (e) => {
		clearInterval(currentIntervalId);
		$("#favorite").prop("checked", false);
	});
	overlay.addEventListener('click', (e) => {
		e.stopPropagation();
		clearInterval(currentIntervalId);
		$("#favorite").prop("checked", false);
	})

}
function openPopup(isbn, title, img, auth, desc, link, link2) {
	initializeFavoriteIcon(isbn);
	var popupTitle = document.getElementById('titlePop');
	var popupImage = document.getElementById('imgPop')
	var overlay = document.getElementsByClassName('overlay')[0]
	var popup = document.getElementById('popup_container')
	var description = $('#description');
	var author = $('#authors');
	var links = document.getElementById('links');
	var links2 = document.getElementById('links2');
	var commentaires = document.getElementById('commentaryArea');
	var idlivre = document.getElementById('isbn');

	//Insertion du spinner de chargement dans les commentaires en attendant le bon chargement de tout les données
	commentaires.innerHTML = spinnerLoadingHtml;

	//Listener sur la fermeture du popup, arret de l'intervale qui recupere les commentaires periodiquement
	popupCloseListening();

	//Si l'icone du coeur est présente c'est qu'on est connecté alors ont verifie si le livre est favori pour afficher le coeur en noir
	if (document.getElementById("favorite")) {
		initializeFavoriteIcon(isbn);
	}


	// Récupération périodique des commentaires
	currentIntervalId = setInterval(() => {
		$.post("/Services/commentaires.php?action=getReplies", { isbn: isbn + "" }).done((d) => {
			if (isbn == document.getElementById('isbn').value) {
				commentaires.innerHTML = d;
			}
		});
	}, 5000);

	idlivre.value = isbn;

	// fonction qui met les infos du livre dans popup
	popup.style.visibility = 'visible';
	popupTitle.innerText = title;
	popupImage.src = img;


	descriptionContent = $("<strong>Description: </strong>");
	spanDescriptionContent = $("<span></span>");
	spanDescriptionContent.html(desc);
	description.html(descriptionContent)
	description.append(spanDescriptionContent)

	authorContent = $('<strong>Authors: </strong>');
	spanAuthorContent = $("<span></span>");
	spanAuthorContent.text(auth);
	author.html(authorContent);
	author.append(spanAuthorContent);

	links.innerHTML = "  <strong> Buy now : </strong></br> <a id='link1' target='_blank'>Amazon <i class='fa fa-amazon'></i> </a>  "
	links2.innerHTML = "<a id='link2' target='_blank'>Apple books <i class='fa fa-apple'></i></a> "
	document.getElementById("link1").href = link;
	document.getElementById("link2").href = link2;
	overlay.style.visibility = 'visible';
	overlay.style.opacity = '1';
};

popup.show = () => {
	overlay.style.visibility = 'visible';
	overlay.style.opacity = '1';
	document.getElementById('popup_container').style.visibility = 'visible';
	var replyRateArea = document.getElementsByClassName("reply-rating");
for (var i = 0; i < replyRateArea.length; i++) {
	  var rate = parseInt(replyRateArea[i].getElementsByTagName("input")[0].value);
	  for (var j = 0; j < rate; j++) {
	    var label = document.createElement("label");
	    label.innerHTML = "&#9733;";
	    replyRateArea[i].appendChild(label);
	  }
	  for (var j = 0; j < 5-rate; j++) {
	    var label = document.createElement("label");
	    label.innerHTML = "☆";
	    replyRateArea[i].appendChild(label);
	  }
}
}

$(document).ready(()=>{
	
})
