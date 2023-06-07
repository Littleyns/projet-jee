package projet.commun.dto;

import java.util.ArrayList;
import java.util.List;

public class DtoEmpruntLivre {
	
	// Champs
	private int id;
	private int	id1;
	private int id2;
	private Boolean accepted;
	
	private int		idlivre;
	
	
	
	
	// Constructeurs
	
	public DtoEmpruntLivre() {
	}

	
	
	public DtoEmpruntLivre(int id, int id1, int id2, Boolean accepted, int idlivre) {
		this.id = id;
		this.id1 = id1;
		this.id2 = id2;
		this.accepted = accepted;
		this.idlivre = idlivre;
	}



	// Getters & setters

	public int getId1() {
		return id1;
	}

	public void setId1(int id1) {
		this.id1 = id1;
	}

	public int getId2() {
		return id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}

	public Boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(Boolean accepted) {
		this.accepted = accepted;
	}

	public int getIdlivre() {
		return idlivre;
	}

	public void setIdlivre(int idlivre) {
		this.idlivre = idlivre;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
