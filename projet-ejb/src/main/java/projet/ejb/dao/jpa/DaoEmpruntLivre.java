package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import projet.ejb.data.UserEmprunt;

@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoEmpruntLivre {
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	

	public int inserer(UserEmprunt emprunt) {
		em.persist(emprunt);
		em.flush();
		return emprunt.getId();
	}

	
	public void modifier(UserEmprunt emprunt) {
		em.merge( emprunt );
	}

	@TransactionAttribute( NOT_SUPPORTED )
	public UserEmprunt retournerEmprunt( int id1, int id2, int idLivre)  {
	    var jpql = "SELECT e FROM UserEmprunt e WHERE e.id1=:id1 AND e.id2=:id2 AND e.idlivre=:idLivre AND e.accepted=true ";
	    var query = em.createQuery( jpql, UserEmprunt.class );
	    query.setParameter( "id1", id1 );
	    query.setParameter( "id2", id2 );
	    query.setParameter( "idLivre", idLivre );
	    try {
	        return query.getSingleResult();
	    } catch ( NoResultException e ) {
	        return null;
	    }
	}
}
