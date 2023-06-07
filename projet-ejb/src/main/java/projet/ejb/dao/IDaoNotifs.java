package projet.ejb.dao;

import java.util.List;

import projet.commun.dto.DtoUserEmprunt;
import projet.commun.dto.DtoUserFriend;
import projet.ejb.data.Compte;
import projet.ejb.data.Livre;
import projet.ejb.data.UserEmprunt;
import projet.ejb.data.UserFriend;
import projet.ejb.data.UsersComment;


public interface IDaoNotifs {

	int			inserer( UsersComment commentaire );

	List<UserFriend> listerTout(Compte c);

	UserFriend retrouver(DtoUserFriend f);

	void accepter(UserFriend uf);

	void refuser(UserFriend uf);

	List<UserEmprunt> listerToutEmprunt(Compte c);

	void accepter(UserEmprunt uf);

	void refuser(UserEmprunt uf);

	UserEmprunt retrouver(DtoUserEmprunt e);


}
