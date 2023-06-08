package projet.ejb.data;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_friend database table.
 * 
 */
@Embeddable
public class UserFriendPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="usr_id_1")
	private Integer usrId1;

	@Column(name="usr_id_2")
	private Integer usrId2;

	public UserFriendPK() {
	}
	public UserFriendPK(Integer u1, Integer u2) {
		this.usrId1 = u1;
		this.usrId2 = u2;
	}
	public Integer getUsrId1() {
		return this.usrId1;
	}
	public void setUsrId1(Integer usrId1) {
		this.usrId1 = usrId1;
	}
	public Integer getUsrId2() {
		return this.usrId2;
	}
	public void setUsrId2(Integer usrId2) {
		this.usrId2 = usrId2;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserFriendPK)) {
			return false;
		}
		UserFriendPK castOther = (UserFriendPK)other;
		return 
			this.usrId1.equals(castOther.usrId1)
			&& this.usrId2.equals(castOther.usrId2);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.usrId1.hashCode();
		hash = hash * prime + this.usrId2.hashCode();
		
		return hash;
	}
}