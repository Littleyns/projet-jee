package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoCompte;
import projet.ejb.dao.IDaoUsersComment;
import projet.ejb.data.Compte;
import projet.ejb.data.Livre;
import projet.ejb.data.UsersComment;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoUsersComment implements IDaoUsersComment {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<UsersComment> listerTout(Livre l) {
		em.clear();
		var jpql = "SELECT c FROM UsersComment WHERE c.livre=:live";
		var query = em.createQuery( jpql, UsersComment.class );
		query.setParameter("livre", l);
		return query.getResultList();
	}


	@Override
	public int inserer(UsersComment commentaire) {
		em.persist(commentaire);
		return 0;
	}


	
}
