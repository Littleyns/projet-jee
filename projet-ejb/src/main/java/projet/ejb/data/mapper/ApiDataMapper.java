package projet.ejb.data.mapper;

import javax.ejb.Local;
import javax.ejb.Stateless;

import projet.commun.dto.DtoLivre;
import projet.ejb.dao.api.ResponseApiGGL;
import projet.ejb.dao.api.ResponseApiNY;

@Stateless
@Local
public class ApiDataMapper {
	public DtoLivre mapNY(ResponseApiNY.Book rBook) {
		return new DtoLivre(rBook.getTitle(),rBook.getDescription(),rBook.getBook_image(),rBook.getAuthor());
	}
	public DtoLivre mapGGL(ResponseApiGGL.Item.Book rBook) {
		String imgLink = rBook.getImageLinks() != null ?  rBook.getImageLinks().getThumbnail() : "";
		return new DtoLivre(rBook.getTitle(),rBook.getDescription(),imgLink,rBook.getAuthors()[0]);
	}
}
