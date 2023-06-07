const myDropDown = document.getElementById("myDropdown");

//Refreshing notifs
processNotifsUI();
  

document.getElementById("notif_container").addEventListener("click", (e)=>{
  
    myFunction();
  document.getElementsByClassName("bi-bell-fill")[0].classList.toggle("showBell");

})


function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

function processNotifsUI(){
	let myDropDown = document.getElementById("myDropdown");
    if(myDropDown.innerHTML!=""){
      $(".bi-bell").addClass("ring-bell");
      $(".bi-bell-fill").addClass("ring-bell");
    }else{
      myDropDown.innerHTML = "<p style='text-align:center;margin-top:5%;'>Aucune notification...</p>";
      $(".bi-bell").removeClass("ring-bell");
      $(".bi-bell-fill").removeClass("ring-bell");
    }
   
  
  
}

function acceptFriend(id){
       $.post("Controller/notifController.php",{acceptFriend:id}).done((d)=>getNotifs())
}

function refuseFriend(id){
          $.post("Controller/notifController.php",{refuseFriend:id}).done((d)=>getNotifs())
}

//get notifications from php service