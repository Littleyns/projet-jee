package projet.commun.dto;

import java.io.Serializable;

public class DtoUserFavori implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer favId;

	private DtoCompte usrId;

	//bi-directional many-to-one association to Livre
	private DtoLivre livre;

	public DtoUserFavori() {
	}
	public DtoUserFavori(DtoCompte u, DtoLivre l) {
		this.usrId = u;
		this.livre = l;
	}

	public Integer getFavId() {
		return this.favId;
	}

	public void setFavId(Integer favId) {
		this.favId = favId;
	}



	public DtoCompte getUsrId() {
		return usrId;
	}

	public void setUsrId(DtoCompte usrId) {
		this.usrId = usrId;
	}

	public DtoLivre getLivre() {
		return this.livre;
	}

	public void setLivre(DtoLivre livre) {
		this.livre = livre;
	}

}
