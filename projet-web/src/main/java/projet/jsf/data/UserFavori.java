package projet.jsf.data;

import java.io.Serializable;

public class UserFavori implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer favId;

	private Compte usrId;

	//bi-directional many-to-one association to Livre
	private Livre livre;

	public UserFavori() {
	}
	public UserFavori(Compte u, Livre l) {
		this.usrId = u;
		this.livre = l;
	}

	public Integer getFavId() {
		return this.favId;
	}

	public void setFavId(Integer favId) {
		this.favId = favId;
	}



	public Compte getUsrId() {
		return usrId;
	}

	public void setUsrId(Compte usrId) {
		this.usrId = usrId;
	}

	public Livre getLivre() {
		return this.livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

}
