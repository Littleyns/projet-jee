package projet.jsf.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
public class Livre implements Serializable {


	// Champs
	
	private Integer			id;
	
	@NotBlank( message = "Le nom doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le nom : 25 car. maxi" )
	private String			nom;

	@Size(max=500, message = "Valeur trop longue pour le prénom : 500 car. maxi" )
	private String			resume;

	private String		categorie;

	private String image;
	
	private String author;
	
	private List<String> replies; //Change to replies
	public String isbn;
	
	// Constructeurs
	
	public Integer getId() {
		return id;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getResume() {
		return resume;
	}


	public void setResume(String resume) {
		this.resume = resume;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public List<String> getReplies() {
		return replies;
	}


	public void setReplies(List<String> replies) {
		this.replies = replies;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Livre() {
	}

}
