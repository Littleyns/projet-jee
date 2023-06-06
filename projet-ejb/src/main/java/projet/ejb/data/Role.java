package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RolePK id;

	public Role() {
	}

	public RolePK getId() {
		return this.id;
	}

	public void setId(RolePK id) {
		this.id = id;
	}

}