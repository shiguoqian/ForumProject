package bean;
/**
 * 管理员发布公告
 */

import java.util.Date;

public class Announce {
	private int annId;			//公告id
	private String comContent;	//公告内容
	private Date comTime;		//发表公告时间
	private int comPriaseNum;	//公告数量
	
	
	
	public Announce() {
		super();
	}



	public Announce(int annId, String comContent, Date comTime) {
		super();
		this.annId = annId;
		this.comContent = comContent;
		this.comTime = comTime;
	}



	public int getAnnId() {
		return annId;
	}



	public void setAnnId(int annId) {
		this.annId = annId;
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
