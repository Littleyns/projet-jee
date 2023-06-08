package projet.ejb.service.standard;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import projet.commun.dto.DtoUserFavori;
import projet.commun.dto.DtoUserFriend;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceUserFavori;
import projet.commun.service.IServiceUserFriend;
import projet.ejb.dao.jpa.DaoUserFavori;
import projet.ejb.dao.jpa.DaoUserFriend;
import projet.ejb.data.UserFavori;
import projet.ejb.data.UserFriend;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceUserFriend implements IServiceUserFriend{

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private DaoUserFriend daoUserFriend;


	// Actions


	public int inserer(DtoUserFriend dtoUserFriend) throws ExceptionValidation {
		int id = daoUserFriend.inserer(mapper.map(dtoUserFriend));
		return id;
	}


	public void modifier(DtoUserFriend dtoUserFriend) throws ExceptionValidation {
		daoUserFriend.modifier(mapper.map(dtoUserFriend));
	}


	public void supprimer(int idUserFriend) throws ExceptionValidation {
		daoUserFriend.supprimer(idUserFriend);
	}

	public DtoUserFriend retrouver(int idUserFriend) {
		return mapper.map(daoUserFriend.retrouver(idUserFriend));
	}


	public List<DtoUserFriend> listerTout(int idUtilisateur) {
		List<DtoUserFriend> liste = new ArrayList<>();
		for (UserFriend friend : daoUserFriend.listerTout(idUtilisateur)) {
			liste.add(mapper.map(friend));
		}
		return liste;
	}
}
