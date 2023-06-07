package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the livre database table.
 * 
 */
@Entity
@NamedQuery(name="Livre.findAll", query="SELECT l FROM Livre l")
public class Livre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = IDENTITY)
	@Column(name="lvr_id")
	private Integer lvrId;

	@Column(name="lvr_isbn")
	private String lvrIsbn;

	@Column(name="lvr_resume")
	private String lvrResume;
	
	@Column(name="lvr_nom")
	private String lvrNom;

	//bi-directional many-to-one association to UserEmprunt
	/*@OneToMany(mappedBy="livre")
	private List<UserEmprunt> userEmprunts;

	//bi-directional many-to-one association to UserFavori
	@OneToMany(mappedBy="livre")
	private List<UserFavori> userFavoris;

	//bi-directional many-to-one association to UsersComment
	@OneToMany(mappedBy="livre")
	private List<UsersComment> usersComments;*/

	public Livre() {
	}
	public Livre(String isbn, String resume,String nom) {
		this.lvrIsbn = isbn;
		this.lvrResume = resume;
		this.lvrNom = nom;
	}

	public Integer getLvrId() {
		return this.lvrId;
	}

	public void setLvrId(Integer lvrId) {
		this.lvrId = lvrId;
	}

	public String getLvrIsbn() {
		return this.lvrIsbn;
	}

	public void setLvrIsbn(String lvrIsbn) {
		this.lvrIsbn = lvrIsbn;
	}

	public String getLvrResume() {
		return this.lvrResume;
	}

	public void setLvrResume(String lvrResume) {
		this.lvrResume = lvrResume;
	}
	public String getLvrNom() {
		return lvrNom;
	}
	public void setLvrNom(String lvrNom) {
		this.lvrNom = lvrNom;
	}








}