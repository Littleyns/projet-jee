package projet.commun.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




@SuppressWarnings("serial")
public class DtoUserEmprunt implements Serializable  {
	private Integer id;

	private Boolean accepted;

	private DtoCompte compte1;

	private DtoCompte compte2;

	private DtoLivre livre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public DtoCompte getCompte1() {
		return compte1;
	}

	public void setCompte1(DtoCompte compte1) {
		this.compte1 = compte1;
	}

	public DtoCompte getCompte2() {
		return compte2;
	}

	public void setCompte2(DtoCompte compte2) {
		this.compte2 = compte2;
	}

	public DtoLivre getLivre() {
		return livre;
	}

	public void setLivre(DtoLivre livre) {
		this.livre = livre;
	}
	
}
