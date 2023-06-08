package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.data.UserFriend;

@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoUserFriend {
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions


	public int inserer(UserFriend fa) {
		em.persist(fa);
		em.flush();
		return fa.getDemandeur().getId();
	}

	
	public void modifier(UserFriend fa) {
		em.merge( fa );
	}

	
	public void supprimer(int idUserFriend) {
		em.remove( retrouver(idUserFriend) );
	}

	
	public UserFriend retrouver(int idUserFriend) {
		return em.find( UserFriend.class, idUserFriend );
	}


	public List<UserFriend> listerTout(int idCompte) {
		em.clear();
		var jpql = "SELECT c FROM UserFavori c WHERE c.usrId1 = "+idCompte;
		var query = em.createQuery( jpql, UserFriend.class );
		return query.getResultList();
	}

}
