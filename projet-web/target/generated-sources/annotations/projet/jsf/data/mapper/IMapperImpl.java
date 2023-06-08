package projet.jsf.data.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoLivre;
import projet.commun.dto.DtoUserFavori;
import projet.jsf.data.Compte;
import projet.jsf.data.Livre;
import projet.jsf.data.UserFavori;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-08T13:25:56+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 18.0.2 (Eclipse Adoptium)"
)
@ApplicationScoped
public class IMapperImpl implements IMapper {

    @Override
    public Compte map(DtoCompte source) {
        if ( source == null ) {
            return null;
        }

        Compte compte = new Compte();

        compte.setId( source.getId() );
        compte.setPseudo( source.getPseudo() );
        compte.setMotDePasse( source.getMotDePasse() );
        compte.setEmail( source.getEmail() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            compte.setRoles( new ArrayList<String>( list ) );
        }

        return compte;
    }

    @Override
    public DtoCompte map(Compte source) {
        if ( source == null ) {
            return null;
        }

        DtoCompte dtoCompte = new DtoCompte();

        dtoCompte.setEmail( source.getEmail() );
        if ( source.getId() != null ) {
            dtoCompte.setId( source.getId() );
        }
        dtoCompte.setMotDePasse( source.getMotDePasse() );
        dtoCompte.setPseudo( source.getPseudo() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            dtoCompte.setRoles( new ArrayList<String>( list ) );
        }

        return dtoCompte;
    }

    @Override
    public Compte duplicate(Compte source) {
        if ( source == null ) {
            return null;
        }

        Compte compte = new Compte();

        compte.setId( source.getId() );
        compte.setPseudo( source.getPseudo() );
        compte.setMotDePasse( source.getMotDePasse() );
        compte.setEmail( source.getEmail() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            compte.setRoles( new ArrayList<String>( list ) );
        }

        return compte;
    }

    @Override
    public Compte update(Compte target, Compte source) {
        if ( source == null ) {
            return target;
        }

        target.setId( source.getId() );
        target.setPseudo( source.getPseudo() );
        target.setMotDePasse( source.getMotDePasse() );
        target.setEmail( source.getEmail() );
        if ( target.getRoles() != null ) {
            List<String> list = source.getRoles();
            if ( list != null ) {
                target.getRoles().clear();
                target.getRoles().addAll( list );
            }
            else {
                target.setRoles( null );
            }
        }
        else {
            List<String> list = source.getRoles();
            if ( list != null ) {
                target.setRoles( new ArrayList<String>( list ) );
            }
        }

        return target;
    }

    @Override
    public Livre map(DtoLivre dtoLivre) {
        if ( dtoLivre == null ) {
            return null;
        }

        Livre livre = new Livre();

        livre.setIsbn( dtoLivre.getIsbn() );
        livre.setId( dtoLivre.getId() );
        livre.setNom( dtoLivre.getNom() );
        livre.setResume( dtoLivre.getResume() );
        livre.setCategorie( dtoLivre.getCategorie() );
        livre.setImage( dtoLivre.getImage() );
        List<String> list = dtoLivre.getReplies();
        if ( list != null ) {
            livre.setReplies( new ArrayList<String>( list ) );
        }
        livre.setAuthor( dtoLivre.getAuthor() );

        return livre;
    }

    @Override
    public UserFavori map(DtoUserFavori dtoUserFavori) {
        if ( dtoUserFavori == null ) {
            return null;
        }

        UserFavori userFavori = new UserFavori();

        userFavori.setFavId( dtoUserFavori.getFavId() );
        userFavori.setUsrId( map( dtoUserFavori.getUsrId() ) );
        userFavori.setLivre( map( dtoUserFavori.getLivre() ) );

        return userFavori;
    }

    @Override
    public DtoUserFavori map(UserFavori userFavori) {
        if ( userFavori == null ) {
            return null;
        }

        DtoUserFavori dtoUserFavori = new DtoUserFavori();

        dtoUserFavori.setFavId( userFavori.getFavId() );
        dtoUserFavori.setLivre( map( userFavori.getLivre() ) );
        dtoUserFavori.setUsrId( map( userFavori.getUsrId() ) );

        return dtoUserFavori;
    }

    @Override
    public DtoLivre map(Livre livre) {
        if ( livre == null ) {
            return null;
        }

        String author = null;
        String image = null;
        String isbn = null;
        String nom = null;
        String resume = null;

        author = livre.getAuthor();
        image = livre.getImage();
        isbn = livre.getIsbn();
        nom = livre.getNom();
        resume = livre.getResume();

        DtoLivre dtoLivre = new DtoLivre( nom, resume, image, author, isbn );

        dtoLivre.setCategorie( livre.getCategorie() );
        dtoLivre.setId( livre.getId() );
        List<String> list = livre.getReplies();
        if ( list != null ) {
            dtoLivre.setReplies( new ArrayList<String>( list ) );
        }

        return dtoLivre;
    }
}
