package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_favori database table.
 * 
 */
@Entity
@Table(name="user_favori")
@NamedQuery(name="UserFavori.findAll", query="SELECT u FROM UserFavori u")
public class UserFavori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = IDENTITY)
	@Column(name="fav_id")
	private Integer favId;

	@OneToOne
	@JoinColumn(name="usr_id")
	private Compte usrId;

	//bi-directional many-to-one association to Livre
	@ManyToOne
	@JoinColumn(name="lvr_id")
	private Livre livre;

	public UserFavori() {
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