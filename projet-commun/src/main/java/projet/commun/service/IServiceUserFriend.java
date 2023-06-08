package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoUserFavori;
import projet.commun.dto.DtoUserFriend;
import projet.commun.exception.ExceptionValidation;

public interface IServiceUserFriend {
	int				inserer( DtoUserFriend dtoUserFriend ) throws ExceptionValidation;

	void			modifier( DtoUserFriend dtoUserFriend ) throws ExceptionValidation; 

	void			supprimer( int idUserFavori ) throws ExceptionValidation;

	DtoUserFriend		retrouver( int idUserFriend) ;

	List<DtoUserFriend>	listerTout(int idUserFriend) ;
}
