package projet.ejb.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoLivre;
import projet.commun.dto.DtoUsersComment;
import projet.ejb.data.Compte;
import projet.ejb.data.Livre;
import projet.ejb.data.UsersComment;

 
@Mapper( componentModel = "cdi" )
public interface IMapperEjb {  
	
	static final IMapperEjb INSTANCE = Mappers.getMapper( IMapperEjb.class );
	
	
	// Compte
	
	Compte map( DtoCompte source );
	
	DtoCompte map( Compte source );

	Livre map(DtoLivre map);

	default DtoUsersComment map(UsersComment u) {
		return new DtoUsersComment(u.getCmtId(),u.getCmtDate(),u.getCmtDescription(),u.getCmtNote(),u.getUser().getPseudo(),u.getLivre().getLvrIsbn());
	};

	
	
}
