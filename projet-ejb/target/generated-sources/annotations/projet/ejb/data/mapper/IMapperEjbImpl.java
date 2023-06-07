package projet.ejb.data.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoLivre;
import projet.commun.dto.DtoUserEmprunt;
import projet.ejb.data.Compte;
import projet.ejb.data.Livre;
import projet.ejb.data.UserEmprunt;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-07T13:21:00+0200",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 18.0.2 (Eclipse Adoptium)"
)
@ApplicationScoped
public class IMapperEjbImpl implements IMapperEjb {

    @Override
    public Compte map(DtoCompte source) {
        if ( source == null ) {
            return null;
        }

        Compte compte = new Compte();

        compte.setEmail( source.getEmail() );
        compte.setId( source.getId() );
        compte.setMotDePasse( source.getMotDePasse() );
        compte.setPseudo( source.getPseudo() );
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
        dtoCompte.setId( source.getId() );
        dtoCompte.setMotDePasse( source.getMotDePasse() );
        dtoCompte.setPseudo( source.getPseudo() );
        List<String> list = source.getRoles();
        if ( list != null ) {
            dtoCompte.setRoles( new ArrayList<String>( list ) );
        }

        return dtoCompte;
    }

    @Override
    public DtoUserEmprunt map(UserEmprunt us) {
        if ( us == null ) {
            return null;
        }

        DtoUserEmprunt dtoUserEmprunt = new DtoUserEmprunt();

        dtoUserEmprunt.setAccepted( us.getAccepted() );
        dtoUserEmprunt.setCompte1( map( us.getCompte1() ) );
        dtoUserEmprunt.setCompte2( map( us.getCompte2() ) );
        dtoUserEmprunt.setId( us.getId() );
        dtoUserEmprunt.setLivre( map( us.getLivre() ) );

        return dtoUserEmprunt;
    }

    @Override
    public UserEmprunt map(DtoUserEmprunt e) {
        if ( e == null ) {
            return null;
        }

        UserEmprunt userEmprunt = new UserEmprunt();

        userEmprunt.setAccepted( e.getAccepted() );
        userEmprunt.setCompte1( map( e.getCompte1() ) );
        userEmprunt.setCompte2( map( e.getCompte2() ) );
        userEmprunt.setId( e.getId() );
        userEmprunt.setLivre( dtoLivreToLivre( e.getLivre() ) );

        return userEmprunt;
    }

    protected Livre dtoLivreToLivre(DtoLivre dtoLivre) {
        if ( dtoLivre == null ) {
            return null;
        }

        Livre livre = new Livre();

        return livre;
    }
}
