package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class ModelGenres implements Serializable {

	final static String[] mockRomanceBooks = {"9780241962473", "8496546993", "8466308989", "0141439343", "0521824362"};
	final static String[] mockITBooks = {"9780596000851", "1726643026", "9781720043997", "9781844807017", "9782744021428"};
	final static String[] mockSciFiBooks = {"3453300440", "080490040X", "0671461494", "9861633839", "1403945772"};
	final static String[] mockThrillerBooks = {"9780843960846", "0922066728", "0670813648", "0099511223", "9780553199864"};
	final static String[] mockMangaBooks = {"9781421585642","9781612620244", "9781421582696", "9781415638286", "9781591168072"};
	final static List<String[]> mockData = new ArrayList<>(Arrays.asList(mockRomanceBooks, mockITBooks, mockSciFiBooks, mockThrillerBooks, mockMangaBooks));
	enum BookCategory {ROMANCE, IT, SCIFI, THRILLER, MANGA} ;  
	
	Map<BookCategory, List<Livre>> livresParCategories;

	@EJB
	private IServiceLivres serviceLivres;
	@Inject
	private IMapper			mapper;
	
	private Livre selectedBook;

	// Getters 
	
	public Map<BookCategory, List<Livre>> getLivresParCategories() {
		if ( livresParCategories == null ) {
			livresParCategories = new HashMap<>();
			for (int i = 0 ;i <  BookCategory.values().length ;i++) {
			      List<Livre> l = new ArrayList<Livre>();
			      livresParCategories.put(BookCategory.values()[i], l);
			      for(String isbn: mockData.get(i)) {
			    	  l.add(mapper.map(serviceLivres.retrouver(isbn)));
			      }
			  			      
			 }
		}
		return livresParCategories;
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
	
	public void setLivresParCategories(Map<BookCategory, List<Livre>> livresParCategories) {
		this.livresParCategories = livresParCategories;
	}
	public boolean isPopupOpen() {
		return this.selectedBook != null;
	}

	}	

