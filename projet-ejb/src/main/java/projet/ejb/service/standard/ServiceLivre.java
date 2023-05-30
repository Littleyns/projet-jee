package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoLivre;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceLivres;
import projet.ejb.dao.IDaoApiLivres;
import projet.ejb.dao.IDaoCompte;
import projet.ejb.dao.jpa.ResponseApiNY;
import projet.ejb.data.Compte;
import projet.ejb.data.mapper.ApiDataMapper;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceLivre implements IServiceLivres {


	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoApiLivres daoApiLivres;
	@Inject
	private ApiDataMapper apiMapper;
	@Override
	public int inserer(DtoLivre dtoLivre) throws ExceptionValidation {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modifier(DtoLivre dtoLivre) throws ExceptionValidation {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void supprimer(int idLivre) throws ExceptionValidation {
		// TODO Auto-generated method stub
		
	}
	@Override
	public DtoLivre retrouver(int idLivre) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<DtoLivre> listerTout() {
		ArrayList<DtoLivre> books = new ArrayList<DtoLivre>();
		ResponseApiNY nyApiBooks = daoApiLivres.getNYApiBooks();
		if(nyApiBooks != null) {
		for(ResponseApiNY.Book book: nyApiBooks.getResults().getBooks()) {
			books.add(apiMapper.mapNY(book));
		}
		}
		return books;
	}



}
