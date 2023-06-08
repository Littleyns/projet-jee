package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.data.UserFavori;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoUserFavori {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions


	public int inserer(UserFavori fa) {
		em.persist(fa);
		em.flush();
		return fa.getFavId();
	}

	
	public void modifier(UserFavori fa) {
		em.merge( fa );
	}

	
	public void supprimer(int idUserFavori) {
		em.remove( retrouver(idUserFavori) );
	}

	
	public UserFavori retrouver(int idUserFavori) {
		return em.find( UserFavori.class, idUserFavori );
	}


	public List<UserFavori> listerTout(int idCompte) {
		em.clear();
		var jpql = "SELECT c FROM UserFavori c WHERE c.usrId = "+idCompte;
		var query = em.createQuery( jpql, UserFavori.class );
		return query.getResultList();
	}


}
