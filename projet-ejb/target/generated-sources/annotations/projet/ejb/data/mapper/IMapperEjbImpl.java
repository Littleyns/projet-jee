package projet.ejb.data.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoUserEmprunt;
import projet.ejb.data.Compte;
import projet.ejb.data.UserEmprunt;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-07T23:50:04+0200",
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
        dtoUserEmprunt.setId( us.getId() );

        return dtoUserEmprunt;
    }

    @Override
    public UserEmprunt map(DtoUserEmprunt e) {
        if ( e == null ) {
            return null;
        }

        UserEmprunt userEmprunt = new UserEmprunt();

        userEmprunt.setId( e.getId() );
        userEmprunt.setAccepted( e.getAccepted() );

        return userEmprunt;
    }
}
