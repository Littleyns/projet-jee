package projet.jsf.model.standard;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoUserFriend;
import projet.commun.service.IServiceCompte;
import projet.commun.service.IServiceNotifs;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.CompteActif;

@SessionScoped
@Named
public class ModelDemandeAmi implements Serializable {

    private String amiUsername; // Le nom d'utilisateur de l'ami à ajouter

    @EJB
    private IServiceNotifs serviceNotifs;
    
    @EJB
    private IServiceCompte serviceCompte;

    @Inject
    private IMapper mapper;

    @Inject
    private CompteActif compteActif;
    
    private String emailDemande;

    public String getAmiUsername() {
        return amiUsername;
    }

    public void setAmiUsername(String amiUsername) {
        this.amiUsername = amiUsername;
    }

    public String getEmailDemande() {
		return emailDemande;
	}

	public void setEmailDemande(String emailDemande) {
		this.emailDemande = emailDemande;
	}

	public void envoyerDemandeAmi() {
    	serviceCompte.envoyerDemande(mapper.map(compteActif), emailDemande);
    }
}
