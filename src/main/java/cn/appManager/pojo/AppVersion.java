package	cn.appManager.pojo;
import java.util.Date;

public class AppVersion {
	private Integer id;
	private Integer appId;
	private String versionNo;
	private String versionInfo;
	private Integer publishStatus;
	private String downloadLink;
	private String versionSize;
	private Integer createdBy;
	private Date creationDate;
	private Integer modifyBy;
	private Date modifyDate;
	private String apkLocPath;
	private String apkFileName;

	private String publishStatusName;
	private String softwareName;

	public String getPublishStatusName() {
		return publishStatusName;
	}

	public void setPublishStatusName(String publishStatusName) {
		this.publishStatusName = publishStatusName;
	}

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

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
	public void setVersionNo(String versionNo){
		this.versionNo = versionNo;
	}
	public String getVersionNo(){
		return versionNo;
	}
	public void setVersionInfo(String versionInfo){
		this.versionInfo = versionInfo;
	}
	public String getVersionInfo(){
		return versionInfo;
	}
	public void setPublishStatus(Integer publishStatus){
		this.publishStatus = publishStatus;
	}
	public Integer getPublishStatus(){
		return publishStatus;
	}
	public void setDownloadLink(String downloadLink){
		this.downloadLink = downloadLink;
	}
	public String getDownloadLink(){
		return downloadLink;
	}
	public void setVersionSize(String versionSize){
		this.versionSize = versionSize;
	}
	public String getVersionSize(){
		return versionSize;
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
	public void setApkLocPath(String apkLocPath){
		this.apkLocPath = apkLocPath;
	}
	public String getApkLocPath(){
		return apkLocPath;
	}
	public void setApkFileName(String apkFileName){
		this.apkFileName = apkFileName;
	}
	public String getApkFileName(){
		return apkFileName;
	}
}
