package bean;

import java.util.Date;

public class Comment {
	
	private int comId;			//评论id
	private String uId;		//评论人id
	private String comContent;	//评论内容
	private Date comTime;		//评论时间
	private int comPriaseNum;	//点赞数量
	
	
	public Comment() {
		super();
	}


	public Comment(int comId, String uId, String comContent, Date comTime) {
		super();
		this.comId = comId;
		this.uId = uId;
		this.comContent = comContent;
		this.comTime = comTime;
	}


	public int getComId() {
		return comId;
	}


	public void setComId(int comId) {
		this.comId = comId;
	}


	public String getuId() {
		return uId;
	}


	public void setuId(String uId) {
		this.uId = uId;
	}


	public String getComContent() {
		return comContent;
	}


	public void setComContent(String comContent) {
		this.comContent = comContent;
	}


	public Date getComTime() {
		return comTime;
	}


	public void setComTime(Date comTime) {
		this.comTime = comTime;
	}


	public int getComPriaseNum() {
		return comPriaseNum;
	}


	public void setComPriaseNum(int comPriaseNum) {
		this.comPriaseNum = comPriaseNum;
	}
	

	
	
	

}
