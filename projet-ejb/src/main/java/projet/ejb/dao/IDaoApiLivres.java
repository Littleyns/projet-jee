package projet.ejb.dao;

import java.util.List;

import projet.commun.dto.DtoLivre;
import projet.ejb.dao.jpa.ResponseApiNY;
import projet.ejb.data.Compte;


public interface IDaoApiLivres {

	ResponseApiNY getNYApiBooks();
	
	//Fonction pour avoir les livres ordonnées par categories

}
