package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoLivre;
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
	
	private Livre selectedBook;
	
	private boolean popupOpen;

	// Getters 
	
	public String openPopup(Livre livre) {
	    this.selectedBook = livre;
	    System.out.println(livre.getNom());
	    return null;
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
	
	

	}	

