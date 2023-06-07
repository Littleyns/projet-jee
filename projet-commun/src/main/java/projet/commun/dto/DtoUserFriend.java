package projet.commun.dto;

import java.io.Serializable;

public class DtoUserFriend implements Serializable {
	private Boolean friendAccepted;
	private DtoCompte demandeur;
	private DtoCompte demande;
	
	public DtoUserFriend(Boolean friendAccepted, DtoCompte demandeur, DtoCompte demande) {
		super();
		this.friendAccepted = friendAccepted;
		this.demandeur = demandeur;
		this.demande = demande;
	}

	public DtoCompte getDemandeur() {
		return demandeur;
	}

	public void setDemandeur(DtoCompte demandeur) {
		this.demandeur = demandeur;
	}

	public DtoCompte getDemande() {
		return demande;
	}

	public void setDemande(DtoCompte demande) {
		this.demande = demande;
	}
	
}
