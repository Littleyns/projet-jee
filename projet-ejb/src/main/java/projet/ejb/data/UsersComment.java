package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the users_comments database table.
 * 
 */
@Entity
@Table(name="users_comments")
@NamedQuery(name="UsersComment.findAll", query="SELECT u FROM UsersComment u")
public class UsersComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cmt_id")
	private Integer cmtId;

	@Temporal(TemporalType.DATE)
	@Column(name="cmt_date")
	private Date cmtDate;

	@Column(name="cmt_description")
	private String cmtDescription;

	@Column(name="cmt_note")
	private Integer cmtNote;

	@ManyToOne
	@JoinColumn(name="usr_id")
	private Compte user;

	//bi-directional many-to-one association to Livre
	@ManyToOne
	@JoinColumn(name="lvr_id")
	private Livre livre;

	public UsersComment() {
	}

	public Integer getCmtId() {
		return this.cmtId;
	}

	public void setCmtId(Integer cmtId) {
		this.cmtId = cmtId;
	}

	public Date getCmtDate() {
		return this.cmtDate;
	}

	public void setCmtDate(Date cmtDate) {
		this.cmtDate = cmtDate;
	}

	public String getCmtDescription() {
		return this.cmtDescription;
	}

	public void setCmtDescription(String cmtDescription) {
		this.cmtDescription = cmtDescription;
	}

	public Integer getCmtNote() {
		return this.cmtNote;
	}

	public void setCmtNote(Integer cmtNote) {
		this.cmtNote = cmtNote;
	}


	public Compte getUser() {
		return user;
	}

	public void setUser(Compte user) {
		this.user = user;
	}

	public Livre getLivre() {
		return this.livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

}