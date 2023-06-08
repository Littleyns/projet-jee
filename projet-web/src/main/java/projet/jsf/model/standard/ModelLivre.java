package projet.jsf.model.standard;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;

import projet.commun.dto.DtoUserEmprunt;
import projet.commun.dto.DtoUserFriend;
import projet.commun.service.IServiceNotifs;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.CompteActif;

public class ModelLivre {
	private List<DtoUserFriend> listeDemandesAmi;
	private List<DtoUserEmprunt> listeDemandesEmprunt;
	@EJB
	private IServiceNotifs serviceNotifs;
	@Inject
	private IMapper			mapper;
	@Inject
	private CompteActif compteActif;

	public List<DtoUserFriend> getListeDemandesAmi() {
			listeDemandesAmi = serviceNotifs.listerTout(mapper.map(compteActif));
		return listeDemandesAmi;
	}
	public List<DtoUserEmprunt> getListeDemandesEmprunt() {
		listeDemandesEmprunt = serviceNotifs.listerToutEmprunt(mapper.map(compteActif));
		System.out.println(listeDemandesEmprunt);
			return listeDemandesEmprunt;
		}

	public void setListeDemandesAmi(List<DtoUserFriend> listeDemandesAmi) {
		this.listeDemandesAmi = listeDemandesAmi;
	}
	
	public void accepter(DtoUserFriend f) {
		serviceNotifs.accepter(f);
	}
	public void refuser(DtoUserFriend f) {
		serviceNotifs.refuser(f);
	}
	public void accepter(DtoUserEmprunt e) {
		serviceNotifs.accepter(e);
	}
	public void refuser(DtoUserEmprunt e) {
		serviceNotifs.refuser(e);
	}

}
