package projet.ejb.dao;

import java.util.List;


import projet.ejb.data.Compte;
import projet.ejb.data.Livre;
import projet.ejb.data.UsersComment;


public interface IDaoLivre {

	int			inserer( Livre livre );

	Livre 		retrouver( String isbn );

	Livre retrouverOuInserer(String isbn);

	List<UsersComment> listerCommentaires(Livre l);

}
