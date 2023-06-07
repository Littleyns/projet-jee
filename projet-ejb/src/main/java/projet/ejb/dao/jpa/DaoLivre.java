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
import projet.ejb.dao.IDaoLivre;
import projet.ejb.data.Compte;
import projet.ejb.data.Livre;
import projet.ejb.data.UserFavori;
import projet.ejb.data.UsersComment;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoLivre implements IDaoLivre {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Livre livre) {
		em.persist(livre);
		em.flush();
		return livre.getLvrId();
	}


	@Override
	public Livre retrouver(String isbn) {
		var jpql = "SELECT l FROM Livre l WHERE l.lvrIsbn=:isbn";
	    var query = em.createQuery( jpql, Livre.class );
	    query.setParameter( "isbn", isbn );
	    try {
	        return query.getSingleResult();
	    } catch ( NoResultException e ) {
	        return null;
	    }
	}
	
	@Override
	public Livre retrouverOuInserer(String isbn, String nom) {
		if(this.retrouver(isbn)==null) {
			this.inserer(new Livre(isbn,"noresume",nom));
		}
		return this.retrouver(isbn);
	}
	
	@Override
	public List<UsersComment> listerCommentaires(Livre l){
		em.clear();
		var jpql = "SELECT c FROM UsersComment c WHERE c.livre = :livre";
		var query = em.createQuery( jpql, UsersComment.class );
		query.setParameter("livre", l);
		return query.getResultList();
	}


	@Override
	public void addToFavorites(Compte map, Livre livre) {
		em.persist(new UserFavori(map,livre));
	}
	@Override
	public void removeFromFavorites(Compte map, Livre livre) {
		var jpql = "SELECT f FROM UserFavori f WHERE f.livre=:livre AND f.usrId = :user";
	    var query = em.createQuery( jpql, UserFavori.class );
	    query.setParameter( "livre", livre );
	    query.setParameter( "user", map );
	    try {
	    	em.remove(query.getSingleResult());
	    } catch ( NoResultException e ) {
	        e.printStackTrace();
	    }
		
	}


	@Override
	public boolean bookIsFavorite(Compte map, Livre livre) {
		var jpql = "SELECT f FROM UserFavori f WHERE f.livre=:livre AND f.usrId = :user";
	    var query = em.createQuery( jpql, UserFavori.class );
	    query.setParameter( "livre", livre );
	    query.setParameter( "user", map );
	    try {
	    	UserFavori u = query.getSingleResult();
	    	return true;
	    } catch ( NoResultException e ) {
	        return false;
	    }
	}


	@Override
	public Livre retrouverOuInserer(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
