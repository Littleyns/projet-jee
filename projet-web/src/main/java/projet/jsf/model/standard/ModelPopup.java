package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoLivre;
import projet.commun.dto.DtoUsersComment;
import projet.commun.service.IServiceConnexion;
import projet.commun.service.IServiceLivres;
import projet.jsf.data.Compte;
import projet.jsf.util.CompteActif;
import projet.jsf.util.UtilJsf;
import projet.jsf.data.Livre;
import projet.jsf.data.mapper.IMapper;

@SuppressWarnings("serial")
@SessionScoped
@Named
public class ModelPopup implements Serializable {

	List<Livre> livres;

	@EJB
	private IServiceLivres serviceLivres;
	@Inject
	private IMapper			mapper;
	
	@Inject
	private CompteActif compteActif;
	private Livre selectedBook;
	
	private boolean popupOpen;
	private String reply;
	private Integer note = 0;
	private List<DtoUsersComment> commentaires;
	boolean favorite = false;

	// Getters 
	
	public String openPopup(Livre livre) {
	    this.selectedBook = livre;
	    this.commentaires = null;
	    this.favorite = serviceLivres.bookIsFavorite(mapper.map(compteActif),mapper.map(this.selectedBook));
	    System.out.println(favorite);
	    return null;
	}
	public List<DtoUsersComment> getCommentaires() {

			if(selectedBook!=null) {
				this.commentaires = serviceLivres.listerCommentaires(mapper.map(this.selectedBook));
				System.out.println(commentaires);
			}
			
		
		return commentaires;
	}
	public void setCommentaires(List<DtoUsersComment> commentaires) {
		this.commentaires = commentaires;
	}
	public void setPopupOpen(boolean popupOpen) {
		this.popupOpen = popupOpen;
	}
	public Livre getSelectedBook() {
		return selectedBook;
	}
	public void setSelectedBook(Livre selectedBook) {
		this.selectedBook = selectedBook;
	}
	
	public boolean isPopupOpen() {
		return popupOpen;
	}
	public String sendReply() {
		serviceLivres.addReply(mapper.map(compteActif), mapper.map(this.selectedBook), this.reply,this.note);
		return "home";
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Integer getNote() {
		return note;
	}
	public void setNote(Integer note) {
		this.note = note;
	}
	public boolean isFavorite() {
		return favorite;
		
	}
	public void setFavorite(boolean isFavorite) {
		if(isFavorite) {
			serviceLivres.addToFavorites(mapper.map(compteActif),mapper.map(this.selectedBook));
		} else {
			serviceLivres.removeFromFavorites(mapper.map(compteActif),mapper.map(this.selectedBook));
		}
		
		this.favorite = isFavorite;
	}
	
	

	}	

