package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoLivre;
import projet.commun.dto.DtoUsersComment;
import projet.commun.exception.ExceptionValidation;


public interface IServiceLivres {
	
	int				inserer( DtoLivre dtoLivre ) throws ExceptionValidation;

	void			modifier( DtoLivre dtoLivre ) throws ExceptionValidation; 

	void			supprimer( int idLivre ) throws ExceptionValidation;

	DtoLivre 		retrouver( String isbn ) ;

	List<DtoLivre>	listerTout() ;

	List<DtoLivre> listerTout(String query);

	void addReply(DtoCompte u, DtoLivre l, String reply, int note);

	List<DtoUsersComment> listerCommentaires(DtoLivre map);

	void addToFavorites(DtoCompte map, DtoLivre map2);

	void removeFromFavorites(DtoCompte map, DtoLivre map2);

	boolean bookIsFavorite(DtoCompte map, DtoLivre map2);

}
