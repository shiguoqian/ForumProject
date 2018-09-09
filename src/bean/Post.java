package bean;

import java.util.Date;

public class Post {
	private int pId; 			// 帖子id
	private int uId;			//用户id
	private String uName;		//用户名
	private String pTitle;		// 帖子标题
	private String pContent;	// 帖子内容
	private int pCheck;			// 审核(1:0)
	private Date pTime;			// 发帖时间
	private int pIsfine;		// 是否精帖(1:0)
	private int pIstop;			// 是否置顶(1:0)
	private int likeNum;		// 点赞数量
	private String type;		//类型
	private String project;		//所属产品
	private String browser;		//浏览器
	private String experience;	//悬赏
	private String version;     //版本号
	public Post() {
		super();
	}
	
	public Post(int pId, int uId, String pTitle, String pContent, int pCheck, Date pTime, int pIsfine, int pIstop,
			int likeNum, String browser,String version, String type, String project, String experience ) {
		this.pId = pId;
		this.uId = uId;
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pCheck = pCheck;
		this.pTime = pTime;
		this.pIsfine = pIsfine;
		this.pIstop = pIstop;
		this.likeNum = likeNum;
		this.type = type;
		this.project = project;
		this.browser = browser;
		this.experience = experience;
		this.version = version;
	}

	public Post(String pTitle, Date pTime) {
		super();
		this.pTitle = pTitle;
		this.pTime = pTime;
	}

	public Post(String uName, String type, String pTitle, String pContent, String experience) {
		super();
		this.uName = uName;
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.type = type;
		this.experience = experience;
	}
	
	public Post( int uId, String pTitle, Date pTime, String type) {
		super();
		this.uId = uId;
		this.pTitle = pTitle;
		this.pTime = pTime;
		this.type = type;
	}

	public Post(int pId, int uId, String pTitle, String pContent, Date pTime, int pIsfine, int pIstop,
			int likeNum,  String browser,String version,String type, String project, String experience, int pCheck) {
		super();
		this.pId = pId;
		this.uId = uId;
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pCheck = pCheck;
		this.pTime = pTime;
		this.pIsfine = pIsfine;
		this.pIstop = pIstop;
		this.likeNum = likeNum;
		this.type = type;
		this.project = project;
		this.browser = browser;
		this.experience = experience;
		this.version = version;
	}


	public Post(String uName,String type, String pTitle, String project, String version, String browser, String pContent,String experience) {
		this.uName = uName;
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.type = type;
		this.project = project;
		this.browser = browser;
		this.experience = experience;
		this.version = version;
	}

	public Post(int pId, String uName, String pTitle, String pContent, int pCheck, Date pTime, int pIsfine, int pIstop) {
		super();
		this.pId = pId;
		this.uName=uName;
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pCheck = pCheck;
		this.pTime = pTime;
		this.pIsfine = pIsfine;
		this.pIstop = pIstop;
	}
	

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public int getpCheck() {
		return pCheck;
	}

	public void setpCheck(int pCheck) {
		this.pCheck = pCheck;
	}

	public Date getpTime() {
		return pTime;
	}

	public void setpTime(Date pTime) {
		this.pTime = pTime;
	}

	public int getpIsfine() {
		return pIsfine;
	}

	public void setpIsfine(int pIsfine) {
		this.pIsfine = pIsfine;
	}

	public int getpIstop() {
		return pIstop;
	}

	public void setpIstop(int pIstop) {
		this.pIstop = pIstop;
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Post [pId=" + pId + ", uId=" + uId + ", uName=" + uName + ", pTitle=" + pTitle + ", pContent="
				+ pContent + ", pCheck=" + pCheck + ", pTime=" + pTime + ", pIsfine=" + pIsfine + ", pIstop=" + pIstop
				+ ", likeNum=" + likeNum + ", type=" + type + ", project=" + project + ", browser=" + browser
				+ ", experience=" + experience + ", version=" + version + "]";
	}
	
	
	
	
	
	
	
	
}
