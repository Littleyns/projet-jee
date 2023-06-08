package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoUserFavori;
import projet.commun.exception.ExceptionValidation;

public interface IServiceUserFavori {
	
	int				inserer( DtoUserFavori dtoCompte ) throws ExceptionValidation;

	void			modifier( DtoUserFavori dtoCompte ) throws ExceptionValidation; 

	void			supprimer( int idUserFavori ) throws ExceptionValidation;

	DtoUserFavori 		retrouver( int idUserFavori) ;

	List<DtoUserFavori>	listerTout(int idUtilisateur) ;

}
