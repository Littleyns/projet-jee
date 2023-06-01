package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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
@ViewScoped
@Named
public class ModelHome implements Serializable {

	List<Livre> livres;

	@EJB
	private IServiceLivres serviceLivres;
	@Inject
	private IMapper			mapper;
	
	private Livre selectedBook;

	// Getters 
	
	public List<Livre> getLivres() {
		if ( livres == null ) {
			livres = new ArrayList<>();
			for(DtoLivre dtoLivre: serviceLivres.listerTout()) {
				livres.add(mapper.map(dtoLivre));
			}
		}
		return livres;
	}
	public String openPopup(Livre livre) {
	    this.selectedBook = livre;
	    System.out.println(livre.getNom());
	    return null;
	}
	public Livre getSelectedBook() {
		return selectedBook;
	}
	public void setSelectedBook(Livre selectedBook) {
		this.selectedBook = selectedBook;
	}
	
	public boolean isPopupOpen() {
		System.out.println("loool");
		return this.selectedBook != null;
	}

	}	

