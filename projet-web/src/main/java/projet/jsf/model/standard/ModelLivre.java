package projet.jsf.model.standard;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoLivre;
import projet.commun.dto.DtoUserEmprunt;
import projet.commun.dto.DtoUserFavori;
import projet.commun.dto.DtoUserFriend;
import projet.commun.service.IServiceLivres;
import projet.commun.service.IServiceNotifs;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.CompteActif;
import java.io.Serializable;
@SuppressWarnings("serial")
@ViewScoped
@Named
public class ModelLivre implements Serializable {
	private List<DtoUserFriend> listeDemandesAmi;
	private List<DtoUserEmprunt> listeDemandesEmprunt;
	private List<DtoUserFavori> livresAmis;
	@EJB
	private IServiceNotifs serviceNotifs;
	@EJB
	private IServiceLivres serviceLivre;
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
	public List<DtoUserFavori> getLivresAmis() {
		if(livresAmis == null) {
			this.livresAmis = serviceLivre.livresDesAmis(mapper.map(compteActif));
		}
		return livresAmis;
	}
	public void setLivresAmis(List<DtoUserFavori> livresAmis) {
		this.livresAmis = livresAmis;
	}
	
	public String emprunter(DtoCompte c, DtoLivre l) {
		serviceLivre.emprunter(mapper.map(compteActif), c, l);
		System.out.println(l.getIsbn());
		return "profil";
	}
	

}
