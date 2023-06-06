package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Compte;
import projet.ejb.data.Livre;
import projet.ejb.data.UsersComment;


public interface IDaoUsersComment {

	int			inserer( UsersComment commentaire );


	List<UsersComment> listerTout(Livre l);


}
