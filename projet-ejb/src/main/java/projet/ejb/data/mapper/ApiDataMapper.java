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
		String imgLink = rBook.getImageLinks() != null ?  rBook.getImageLinks().getThumbnail() : "https://m.media-amazon.com/images/I/31owm8jIVVL._AC_UF1000,1000_QL80_.jpg";
		return new DtoLivre(rBook.getTitle(),rBook.getDescription(),imgLink,rBook.getAuthors()!=null ? rBook.getAuthors()[0]: "unknownAuthor");
	}
}
