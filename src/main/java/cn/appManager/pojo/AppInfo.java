package	cn.appManager.pojo;
import java.util.Date;

public class AppInfo {
	private Integer id;
	private String softwareName;
	private String APKName;
	private String supportROM;
	private String interfaceLanguage;
	private Double softwareSize; //软件大小
	private Date updateDate; //修改日期
	private Integer devId;
	private String appInfo; //信息
	private Integer status; //状态
	private Date onSaleDate;
	private Date offSaleDate;
	private Integer flatformId;
	private Integer categoryLevel3; //三级分类
	private Integer categoryLevel2; //二级分类
	private Integer categoryLevel1; //一级分类
	private Integer downloads; //下载次数
	private Integer createdBy;
	private Date creationDate;
	private Integer modifyBy;
	private Date modifyDate;
	private String logoPicPath;
	private String logoLocPath;
	private Integer versionId;

	//定义新的属性
	private String category1Name;
	private String category2Name;
	private String category3Name;
	private String statusName;
	private String flatformName;
	private String versionSize;


	public String getCategory1Name() {
		return category1Name;
	}

	public void setCategory1Name(String category1Name) {
		this.category1Name = category1Name;
	}

	public String getCategory2Name() {
		return category2Name;
	}

	public void setCategory2Name(String category2Name) {
		this.category2Name = category2Name;
	}

	public String getCategory3Name() {
		return category3Name;
	}

	public void setCategory3Name(String category3Name) {
		this.category3Name = category3Name;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getFlatformName() {
		return flatformName;
	}

	public void setFlatformName(String flatformName) {
		this.flatformName = flatformName;
	}

	public String getVersionSize() {
		return versionSize;
	}

	public void setVersionSize(String versionSize) {
		this.versionSize = versionSize;
	}

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return id;
	}
	public void setSoftwareName(String softwareName){
		this.softwareName = softwareName;
	}
	public String getSoftwareName(){
		return softwareName;
	}
	public void setAPKName(String APKName){
		this.APKName = APKName;
	}
	public String getAPKName(){
		return APKName;
	}
	public void setSupportROM(String supportROM){
		this.supportROM = supportROM;
	}
	public String getSupportROM(){
		return supportROM;
	}
	public void setInterfaceLanguage(String interfaceLanguage){
		this.interfaceLanguage = interfaceLanguage;
	}
	public String getInterfaceLanguage(){
		return interfaceLanguage;
	}
	public void setSoftwareSize(Double softwareSize){
		this.softwareSize = softwareSize;
	}
	public Double getSoftwareSize(){
		return softwareSize;
	}
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	public Date getUpdateDate(){
		return updateDate;
	}
	public void setDevId(Integer devId){
		this.devId = devId;
	}
	public Integer getDevId(){
		return devId;
	}
	public void setAppInfo(String appInfo){
		this.appInfo = appInfo;
	}
	public String getAppInfo(){
		return appInfo;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus(){
		return status;
	}
	public void setOnSaleDate(Date onSaleDate){
		this.onSaleDate = onSaleDate;
	}
	public Date getOnSaleDate(){
		return onSaleDate;
	}
	public void setOffSaleDate(Date offSaleDate){
		this.offSaleDate = offSaleDate;
	}
	public Date getOffSaleDate(){
		return offSaleDate;
	}
	public void setFlatformId(Integer flatformId){
		this.flatformId = flatformId;
	}
	public Integer getFlatformId(){
		return flatformId;
	}
	public void setCategoryLevel3(Integer categoryLevel3){
		this.categoryLevel3 = categoryLevel3;
	}
	public Integer getCategoryLevel3(){
		return categoryLevel3;
	}
	public void setCategoryLevel2(Integer categoryLevel2){
		this.categoryLevel2 = categoryLevel2;
	}
	public Integer getCategoryLevel2(){
		return categoryLevel2;
	}
	public void setCategoryLevel1(Integer categoryLevel1){
		this.categoryLevel1 = categoryLevel1;
	}
	public Integer getCategoryLevel1(){
		return categoryLevel1;
	}
	public void setDownloads(Integer downloads){
		this.downloads = downloads;
	}
	public Integer getDownloads(){
		return downloads;
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
	public void setLogoPicPath(String logoPicPath){
		this.logoPicPath = logoPicPath;
	}
	public String getLogoPicPath(){
		return logoPicPath;
	}
	public void setLogoLocPath(String logoLocPath){
		this.logoLocPath = logoLocPath;
	}
	public String getLogoLocPath(){
		return logoLocPath;
	}
	public void setVersionId(Integer versionId){
		this.versionId = versionId;
	}
	public Integer getVersionId(){
		return versionId;
	}
}
