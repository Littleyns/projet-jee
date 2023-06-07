package projet.ejb.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoLivre;
import projet.commun.dto.DtoUserEmprunt;
import projet.commun.dto.DtoUserFriend;
import projet.commun.dto.DtoUsersComment;
import projet.ejb.data.Compte;
import projet.ejb.data.Livre;
import projet.ejb.data.UserEmprunt;
import projet.ejb.data.UserFriend;
import projet.ejb.data.UsersComment;

 
@Mapper( componentModel = "cdi" )
public interface IMapperEjb {  
	
	static final IMapperEjb INSTANCE = Mappers.getMapper( IMapperEjb.class );
	
	
	// Compte
	
	Compte map( DtoCompte source );
	
	DtoCompte map( Compte source );

	default DtoLivre map(Livre l) {
		return new DtoLivre(l.getLvrNom(),l.getLvrResume(),"","",l.getLvrIsbn());
	}


	default DtoUsersComment map(UsersComment u) {
		return new DtoUsersComment(u.getCmtId(),u.getCmtDate(),u.getCmtDescription(),u.getCmtNote(),u.getUser().getPseudo(),u.getLivre().getLvrIsbn());
	};
	
	default DtoUserFriend map(UserFriend u) {
		return new DtoUserFriend(u.getFriendAccepted(),this.map(u.getDemandeur()),this.map(u.getDemande()));
	}

	DtoUserEmprunt map(UserEmprunt us);

	UserEmprunt map(DtoUserEmprunt e);

	
	
}
