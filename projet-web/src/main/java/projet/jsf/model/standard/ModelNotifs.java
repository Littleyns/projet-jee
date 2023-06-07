package projet.jsf.model.standard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoLivre;
import projet.commun.dto.DtoUserEmprunt;
import projet.commun.dto.DtoUserFriend;
import projet.commun.dto.DtoUsersComment;
import projet.commun.service.IServiceConnexion;
import projet.commun.service.IServiceLivres;
import projet.commun.service.IServiceNotifs;
import projet.jsf.data.Compte;
import projet.jsf.util.CompteActif;
import projet.jsf.util.UtilJsf;
import projet.jsf.data.Livre;
import projet.jsf.data.mapper.IMapper;

@SuppressWarnings("serial")
@SessionScoped
@Named
public class ModelNotifs implements Serializable {

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

