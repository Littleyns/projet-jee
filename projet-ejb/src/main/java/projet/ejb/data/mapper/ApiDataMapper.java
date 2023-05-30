package projet.ejb.data.mapper;

import javax.ejb.Local;
import javax.ejb.Stateless;

import projet.commun.dto.DtoLivre;
import projet.ejb.dao.jpa.ResponseApiNY;

@Stateless
@Local
public class ApiDataMapper {
	public DtoLivre mapNY(ResponseApiNY.Book rBook) {
		return new DtoLivre(rBook.getTitle(),rBook.getDescription(),rBook.getBook_image(),rBook.getAuthor());
	}
}
