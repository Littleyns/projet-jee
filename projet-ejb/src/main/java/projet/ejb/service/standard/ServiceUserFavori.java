package projet.ejb.service.standard;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import projet.commun.dto.DtoUserFavori;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceUserFavori;
import projet.ejb.dao.jpa.DaoUserFavori;
import projet.ejb.data.UserFavori;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceUserFavori implements IServiceUserFavori{

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private DaoUserFavori daoUserFavori;


	// Actions


	public int inserer(DtoUserFavori dtoUserFavori) throws ExceptionValidation {
		int id = daoUserFavori.inserer(mapper.map(dtoUserFavori));
		return id;
	}


	public void modifier(DtoUserFavori dtoUserFavori) throws ExceptionValidation {
		daoUserFavori.modifier(mapper.map(dtoUserFavori));
	}


	public void supprimer(int idUserFavori) throws ExceptionValidation {
		daoUserFavori.supprimer(idUserFavori);
	}

	public DtoUserFavori retrouver(int idUserFavori) {
		return mapper.map(daoUserFavori.retrouver(idUserFavori));
	}


	public List<DtoUserFavori> listerTout(int idUtilisateur) {
		List<DtoUserFavori> liste = new ArrayList<>();
		for (UserFavori favori : daoUserFavori.listerTout(idUtilisateur)) {
			liste.add(mapper.map(favori));
		}
		return liste;
	}
}
