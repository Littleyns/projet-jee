package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoLivre;
import projet.commun.exception.ExceptionValidation;


public interface IServiceLivres {
	
	int				inserer( DtoLivre dtoLivre ) throws ExceptionValidation;

	void			modifier( DtoLivre dtoLivre ) throws ExceptionValidation; 

	void			supprimer( int idLivre ) throws ExceptionValidation;

	DtoLivre 		retrouver( String isbn ) ;

	List<DtoLivre>	listerTout() ;

}
