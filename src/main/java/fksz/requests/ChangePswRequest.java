package fksz.requests;

public class ChangePswRequest {
	
	private int userId;
	private String oldPsw;
	private String newPsw;
	private String newPswAgain;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOldPsw() {
		return oldPsw;
	}
	public void setOldPsw(String oldPsw) {
		this.oldPsw = oldPsw;
	}
	public String getNewPsw() {
		return newPsw;
	}
	public void setNewPsw(String newPsw) {
		this.newPsw = newPsw;
	}
	public String getNewPswAgain() {
		return newPswAgain;
	}
	public void setNewPswAgain(String newPswAgain) {
		this.newPswAgain = newPswAgain;
	}
	
	

}
