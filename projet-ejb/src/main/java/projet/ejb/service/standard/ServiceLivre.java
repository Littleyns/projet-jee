package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
import projet.ejb.dao.IDaoUsersComment;
import projet.ejb.dao.api.ResponseApiGGL;
import projet.ejb.dao.api.ResponseApiNY;
import projet.ejb.data.Compte;
import projet.ejb.data.UsersComment;
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
	private IDaoUsersComment daoUsersComment;
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
	public DtoLivre retrouver(String isbn) {
		ResponseApiGGL responseApiGGL= daoApiLivres.getGGLApiBook(isbn);
		return apiMapper.mapGGL(responseApiGGL.getItems()[0].getVolumeInfo());
	}
	@Override
	public List<DtoLivre> listerTout(String query) {
		String queryEncoded="tintin";
		try {
			queryEncoded = URLEncoder.encode(query, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<DtoLivre> res = new ArrayList<DtoLivre>();
		ResponseApiGGL responseApiGGL= daoApiLivres.getGGLApiBookByQuery(queryEncoded);
		for(ResponseApiGGL.Item item: responseApiGGL.getItems()) {
			res.add(apiMapper.mapGGL(item.getVolumeInfo()));
		}
		return res;
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
	
	@Override
	public void addReply(DtoCompte u, DtoLivre l, String reply, int note) {
		daoUsersComment.inserer(new UsersComment());
	}



}
