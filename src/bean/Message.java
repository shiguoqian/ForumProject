package bean;

import java.util.Date;

public class Message {
	private int pId; 			// 帖子id
	private int uId;			//用户id
	private String uName;		//用户名
	private String pTitle;		// 帖子标题
	private Date pTime;			// 发帖时间
	private String type;		//类型
	private String pContent;		//帖子内容
	public Message(int pId, int uId, String uName, String pTitle, Date pTime,String type) {
		super();
		this.pId = pId;
		this.uId = uId;
		this.uName = uName;
		this.pTitle = pTitle;
		this.pTime = pTime;
		this.type = type;
	}
	/**
	 * wanp,用于点击帖子展现内容
	 * @param pId
	 * @param uName
	 * @param pTitle
	 * @param pTime
	 * @param type
	 * @param pContent
	 */
	
	public Message(int pId, String uName, String pTitle, Date pTime, String type, String pContent) {
		super();
		this.pId = pId;
		this.uName = uName;
		this.pTitle = pTitle;
		this.pTime = pTime;
		this.type = type;
		this.pContent = pContent;
	}


	public Message() {
		
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getpTitle() {
		return pTitle;
	}
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	public Date getpTime() {
		return pTime;
	}
	public void setpTime(Date pTime) {
		this.pTime = pTime;
	}
	@Override
	public String toString() {
		return "Message [pId=" + pId + ", uId=" + uId + ", uName=" + uName + ", pTitle=" + pTitle + ", pTime=" + pTime
				+ ", type=" + type + ", pContent=" + pContent + "]";
	}
	
	
}
