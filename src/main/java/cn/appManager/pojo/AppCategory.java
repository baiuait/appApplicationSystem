package	cn.appManager.pojo;
import java.util.Date;

public class AppCategory {
	private Integer id;
	private String categoryCode; //分类编码
	private String categoryName; //分类名称
	private Integer parentId; //分类父分类id
	private Integer createdBy;
	private Date creationDate;
	private Integer modifyBy;
	private Date modifyDate;

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setCategoryCode(String categoryCode){
		this.categoryCode = categoryCode;
	}
	public String getCategoryCode(){
		return categoryCode;
	}
	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}
	public String getCategoryName(){
		return categoryName;
	}
	public void setParentId(Integer parentId){
		this.parentId = parentId;
	}
	public Integer getParentId(){
		return parentId;
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
}
