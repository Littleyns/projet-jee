package projet.ejb.dao;

import java.util.List;

import projet.commun.dto.DtoLivre;
import projet.ejb.dao.api.ResponseApiGGL;
import projet.ejb.dao.api.ResponseApiNY;
import projet.ejb.data.Compte;


public interface IDaoApiLivres {

	ResponseApiNY getNYApiBooks();
	ResponseApiGGL getGGLApiBook(String isbn);
	
	//Fonction pour avoir les livres ordonnées par categories

}
