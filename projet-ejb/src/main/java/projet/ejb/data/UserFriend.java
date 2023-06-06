package projet.ejb.data;

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

	@EmbeddedId
	private UserFriendPK id;

	@Column(name="friend_accepted")
	private Boolean friendAccepted;

	@JoinColumn(name="usr_id_1" , insertable = false, updatable = false)
	@OneToOne
	private Compte demandeur;
	@JoinColumn(name="usr_id_2" , insertable = false, updatable = false)
	@OneToOne
	private Compte demande;
	
	public UserFriend() {
	}

	public UserFriendPK getId() {
		return this.id;
	}

	public void setId(UserFriendPK id) {
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