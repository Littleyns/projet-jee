package projet.jsf.model.standard;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projet.commun.dto.DtoUserEmprunt;
import projet.commun.dto.DtoUserFavori;
import projet.commun.dto.DtoUserFriend;
import projet.commun.service.IServiceNotifs;
import projet.commun.service.IServiceUserFavori;
import projet.jsf.data.UserFavori;
import projet.jsf.data.mapper.IMapper;
import projet.jsf.util.CompteActif;

@RequestScoped
@Named
public class ModelFavori {
	private List<DtoUserFavori> listeFavori;
	@EJB
	private IServiceUserFavori serviceUserFavori;
	@Inject
	private IMapper			mapper;
	@Inject
	private CompteActif compteActif;

	
	public List<DtoUserFavori> getListFavori(){
		listeFavori = serviceUserFavori.listerTout(compteActif.getId());
		return listeFavori;
	}

}
