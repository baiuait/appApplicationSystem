package	cn.appManager.pojo;
import java.util.Date;

/**
 * 促销类
 */
public class AdPromotion {
	private Integer id;
	private Integer appId; //app编号
	private String adPicPath; //图片路径
	private Integer adPV;
	private Integer carouselPosition;
	private Date startTime; //开始时间
	private Date endTime; //结束时间
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
	public void setAppId(Integer appId){
		this.appId = appId;
	}
	public Integer getAppId(){
		return appId;
	}
	public void setAdPicPath(String adPicPath){
		this.adPicPath = adPicPath;
	}
	public String getAdPicPath(){
		return adPicPath;
	}
	public void setAdPV(Integer adPV){
		this.adPV = adPV;
	}
	public Integer getAdPV(){
		return adPV;
	}
	public void setCarouselPosition(Integer carouselPosition){
		this.carouselPosition = carouselPosition;
	}
	public Integer getCarouselPosition(){
		return carouselPosition;
	}
	public void setStartTime(Date startTime){
		this.startTime = startTime;
	}
	public Date getStartTime(){
		return startTime;
	}
	public void setEndTime(Date endTime){
		this.endTime = endTime;
	}
	public Date getEndTime(){
		return endTime;
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
