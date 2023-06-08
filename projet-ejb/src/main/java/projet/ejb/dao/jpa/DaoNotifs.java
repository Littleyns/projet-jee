package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import projet.commun.dto.DtoUserEmprunt;
import projet.commun.dto.DtoUserFriend;
import projet.ejb.dao.IDaoCompte;
import projet.ejb.dao.IDaoNotifs;
import projet.ejb.dao.IDaoUsersComment;
import projet.ejb.data.Compte;
import projet.ejb.data.Livre;
import projet.ejb.data.UserEmprunt;
import projet.ejb.data.UserFriend;
import projet.ejb.data.UsersComment;
import projet.ejb.data.mapper.IMapperEjb;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoNotifs implements IDaoNotifs {

	
	// Champs
	@Inject
	private IMapperEjb mapper;
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<UserFriend> listerTout(Compte c) {
		em.clear();
		var jpql = "SELECT f FROM UserFriend f WHERE f.demande = :compte AND f.friendAccepted = false";
		var query = em.createQuery( jpql, UserFriend.class );
		query.setParameter("compte", c);
		return query.getResultList();
	}
	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<UserEmprunt> listerToutEmprunt(Compte c) {
		em.clear();
		var jpql = "SELECT f FROM UserEmprunt f WHERE f.compte2 = :compte AND f.accepted = false";
		var query = em.createQuery( jpql, UserEmprunt.class );
		query.setParameter("compte", c);
		return query.getResultList();
	}


	@Override
	public int inserer(UsersComment commentaire) {
		em.persist(commentaire);
		return 0;
	}


	@Override
	public UserFriend retrouver(DtoUserFriend f) {
		em.clear();
		var jpql = "SELECT f FROM UserFriend f WHERE f.demande = :compte AND f.demandeur = :compte2";
		var query = em.createQuery( jpql, UserFriend.class );
		query.setParameter("compte", mapper.map(f.getDemande()));
		query.setParameter("compte2", mapper.map(f.getDemandeur()));
		return query.getSingleResult();
	}


	@Override
	public void accepter(UserFriend uf) {
		uf.setFriendAccepted(true);
		em.merge(uf);
		
	}


	@Override
	public void refuser(UserFriend uf) {
		em.remove(uf);
		
	}
	@Override
	public void accepter(UserEmprunt emp) {
		emp.setAccepted(true);
		((EntityManager) em).merge(emp);
		
	}


	@Override
	public void refuser(UserEmprunt emp) {
		((EntityManager) em).remove(emp);
		
	}
	@Override
	public UserEmprunt retrouver(DtoUserEmprunt e) {
		em.clear();
		var jpql = "SELECT f FROM UserEmprunt f WHERE f.compte1 = :compte AND f.compte2 = :compte2";
		var query = em.createQuery( jpql, UserEmprunt.class );
		query.setParameter("compte", mapper.map(e.getCompte1()));
		query.setParameter("compte2", mapper.map(e.getCompte2()));
		return query.getSingleResult();
	}
	
}
