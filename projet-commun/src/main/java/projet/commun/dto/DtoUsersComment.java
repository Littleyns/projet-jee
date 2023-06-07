package projet.commun.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@SuppressWarnings("serial")
public class DtoUsersComment implements Serializable  {

	private Integer cmtId;

	private Date cmtDate;


	private String cmtDescription;


	private Integer cmtNote;
	private int cmtNoteInt;

	private String userPseudo;


	private String livreIsbn;


	public DtoUsersComment(Integer cmtId, Date cmtDate, String cmtDescription, Integer cmtNote, String userPseudo,
			String livreIsbn) {
		super();
		this.cmtId = cmtId;
		this.cmtDate = cmtDate;
		this.cmtDescription = cmtDescription;
		this.cmtNote = cmtNote;
		this.userPseudo = userPseudo;
		this.livreIsbn = livreIsbn;
	}


	public Integer getCmtId() {
		return cmtId;
	}


	public int getCmtNoteInt() {
		return cmtNote.intValue();
	}


	public void setCmtNoteInt(int cmtNoteInt) {
		this.cmtNoteInt = cmtNoteInt;
	}


	public void setCmtId(Integer cmtId) {
		this.cmtId = cmtId;
	}


	public Date getCmtDate() {
		return cmtDate;
	}


	public void setCmtDate(Date cmtDate) {
		this.cmtDate = cmtDate;
	}


	public String getCmtDescription() {
		return cmtDescription;
	}


	public void setCmtDescription(String cmtDescription) {
		this.cmtDescription = cmtDescription;
	}


	public Integer getCmtNote() {
		return cmtNote;
	}


	public void setCmtNote(Integer cmtNote) {
		this.cmtNote = cmtNote;
	}


	public String getUserPseudo() {
		return userPseudo;
	}


	public void setUserPseudo(String userPseudo) {
		this.userPseudo = userPseudo;
	}


	public String getLivreIsbn() {
		return livreIsbn;
	}


	public void setLivreIsbn(String livreIsbn) {
		this.livreIsbn = livreIsbn;
	}
	
	
}
