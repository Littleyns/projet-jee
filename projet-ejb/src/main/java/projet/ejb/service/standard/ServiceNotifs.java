package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoUserEmprunt;
import projet.commun.dto.DtoUserFriend;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceCompte;
import projet.commun.service.IServiceNotifs;
import projet.ejb.dao.IDaoCompte;
import projet.ejb.dao.IDaoNotifs;
import projet.ejb.data.Compte;
import projet.ejb.data.UserEmprunt;
import projet.ejb.data.UserFriend;
import projet.ejb.data.mapper.ApiDataMapper;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceNotifs implements IServiceNotifs {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoNotifs daoNotifs;


	@Override
	public List<DtoUserFriend> listerTout(DtoCompte c) {
		
		List<UserFriend> u = daoNotifs.listerTout(mapper.map(c));
		List<DtoUserFriend> res = new ArrayList<>();
		for(UserFriend us: u) {
			res.add(mapper.map(us));
		}
		return res;
	}


	@Override
	public void accepter(DtoUserFriend f) {
		UserFriend uf = daoNotifs.retrouver(f);
		daoNotifs.accepter(uf);
		
	}


	@Override
	public void refuser(DtoUserFriend f) {
		UserFriend uf = daoNotifs.retrouver(f);
		daoNotifs.refuser(uf);
		
	}


	@Override
	public List<DtoUserEmprunt> listerToutEmprunt(DtoCompte map) {

		List<UserEmprunt> u = daoNotifs.listerToutEmprunt(mapper.map(map));
		List<DtoUserEmprunt> res = new ArrayList<>();
		for(UserEmprunt us: u) {
			res.add(mapper.map(us));
		}
		System.out.println(res);
		return res;
	}


	@Override
	public void accepter(DtoUserEmprunt e) {
		UserEmprunt em = daoNotifs.retrouver(e);
		daoNotifs.accepter(em);
		
	}


	@Override
	public void refuser(DtoUserEmprunt e) {
		UserEmprunt em = daoNotifs.retrouver(e);
		daoNotifs.refuser(em);
		
	}


}
