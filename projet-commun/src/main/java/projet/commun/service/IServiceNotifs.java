package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoUserEmprunt;
import projet.commun.dto.DtoUserFriend;
import projet.commun.exception.ExceptionValidation;


public interface IServiceNotifs {

	List<DtoUserFriend> listerTout(DtoCompte c);

	void accepter(DtoUserFriend f);

	void refuser(DtoUserFriend f);

	List<DtoUserEmprunt> listerToutEmprunt(DtoCompte map);

	void accepter(DtoUserEmprunt e);

	void refuser(DtoUserEmprunt e);
	


}
