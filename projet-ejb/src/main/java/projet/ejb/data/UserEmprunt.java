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
	private int id1;
	
	@OneToOne
	@JoinColumn(name="idcompte2")
	private int id2;

	//bi-directional many-to-one association to Livre
	@OneToOne
	@JoinColumn(name="lvr_id")
	private int idlivre;

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



	public int getId1() {
		return id1;
	}

	public void setId1(int id1) {
		this.id1 = id1;
	}

	public int getId2() {
		return id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}

	public int getIdlivre() {
		return idlivre;
	}

	public void setIdlivre(int idlivre) {
		this.idlivre = idlivre;
	}

	 

}