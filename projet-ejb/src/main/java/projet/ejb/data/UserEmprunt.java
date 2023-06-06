package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_emprunt database table.
 * 
 */
@Entity
@Table(name="user_emprunt")
@NamedQuery(name="UserEmprunt.findAll", query="SELECT u FROM UserEmprunt u")
public class UserEmprunt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean accepted;

	@OneToOne
	@JoinColumn(name="idcompte1")
	private Compte compte1;
	
	@OneToOne
	@JoinColumn(name="idcompte2")
	private Compte compte2;

	//bi-directional many-to-one association to Livre
	@ManyToOne
	@JoinColumn(name="lvr_id")
	private Livre livre;

	public UserEmprunt() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAccepted() {
		return this.accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}



	public Compte getCompte1() {
		return compte1;
	}

	public void setCompte1(Compte compte1) {
		this.compte1 = compte1;
	}

	public Compte getCompte2() {
		return compte2;
	}

	public void setCompte2(Compte compte2) {
		this.compte2 = compte2;
	}

	public Livre getLivre() {
		return this.livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

}