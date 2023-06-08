package projet.jsf.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoLivre;
import projet.commun.dto.DtoUserFavori;
import projet.jsf.data.Compte;
import projet.jsf.data.Livre;
import projet.jsf.data.UserFavori;


@Mapper( componentModel = "cdi" )
public interface IMapper {
  

	// Compte
	
	Compte    map( DtoCompte source );
	
	DtoCompte map( Compte source );
	
	Compte duplicate( Compte source );

	Compte update( @MappingTarget Compte target, Compte source );

	Livre map(DtoLivre dtoLivre);
	UserFavori map(DtoUserFavori dtoUserFavori);
	
	DtoUserFavori map(UserFavori userFavori);
	
	DtoLivre map(Livre livre);

}
