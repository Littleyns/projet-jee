package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Livre
 *
 */
@Entity
@Table(name="livre")
public class Livre implements Serializable {

	@Id
	@GeneratedValue( strategy = IDENTITY)
	@Column( name = "idLivre")
	private int		id;
	
	@Column( name = "isbn")
	private String isbn;
	private static final long serialVersionUID = 1L;
	
	public Livre() {
		super();
	}   
	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
   
}
