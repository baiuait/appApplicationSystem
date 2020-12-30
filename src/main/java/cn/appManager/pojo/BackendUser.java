package	cn.appManager.pojo;
import java.util.Date;

public class BackendUser {
	private Integer id;
	private String userCode;
	private String userName;
	private Integer userType;
	private Integer createdBy;
	private Date creationDate;
	private Integer modifyBy;
	private Date modifyDate;
	private String userPassword;

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setUserCode(String userCode){
		this.userCode = userCode;
	}
	public String getUserCode(){
		return userCode;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserType(Integer userType){
		this.userType = userType;
	}
	public Integer getUserType(){
		return userType;
	}
	public void setCreatedBy(Integer createdBy){
		this.createdBy = createdBy;
	}
	public Integer getCreatedBy(){
		return createdBy;
	}
	public void setCreationDate(Date creationDate){
		this.creationDate = creationDate;
	}
	public Date getCreationDate(){
		return creationDate;
	}
	public void setModifyBy(Integer modifyBy){
		this.modifyBy = modifyBy;
	}
	public Integer getModifyBy(){
		return modifyBy;
	}
	public void setModifyDate(Date modifyDate){
		this.modifyDate = modifyDate;
	}
	public Date getModifyDate(){
		return modifyDate;
	}
	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}
	public String getUserPassword(){
		return userPassword;
	}
}
