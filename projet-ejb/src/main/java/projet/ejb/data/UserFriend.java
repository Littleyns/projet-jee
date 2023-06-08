package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_friend database table.
 * 
 */
@Entity
@Table(name="user_friend")
@NamedQuery(name="UserFriend.findAll", query="SELECT u FROM UserFriend u")
public class UserFriend implements Serializable {
	private static final long serialVersionUID = 1L;

		@Id
	@GeneratedValue( strategy = IDENTITY)
		@Column(name ="IdUserFriend")
	private Integer id;

	@Column(name="friend_accepted")
	private Boolean friendAccepted;

	@JoinColumn(name="usr_id_1" )
	@OneToOne
	private Compte demandeur;
	@JoinColumn(name="usr_id_2" )
	@OneToOne
	private Compte demande;
	
	public UserFriend() {
	}
	public UserFriend(Compte demandeur, Compte demande, boolean accepted) {
		this.demandeur = demandeur;
		this.demande = demande;
		this.friendAccepted= accepted;
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getFriendAccepted() {
		return this.friendAccepted;
	}

	public void setFriendAccepted(Boolean friendAccepted) {
		this.friendAccepted = friendAccepted;
	}

	public Compte getDemandeur() {
		return demandeur;
	}

	public void setDemandeur(Compte demandeur) {
		this.demandeur = demandeur;
	}

	public Compte getDemande() {
		return demande;
	}

	public void setDemande(Compte demande) {
		this.demande = demande;
	}

}