package bean;

import java.util.Date;

public class Advise {
	private int adId;			//建议id
	private int uId;			//建议人
	private String adContent;	//建议内容
	private Date adTime;		//发表建议时间
	private int adPriaseNum;	//建议数量数量
	
	public Advise() {
		super();
	}

	public Advise(int adId, int uId, String adContent, Date adTime) {
		super();
		this.adId = adId;
		this.uId = uId;
		this.adContent = adContent;
		this.adTime = adTime;
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getAdContent() {
		return adContent;
	}

	public void setAdContent(String adContent) {
		this.adContent = adContent;
	}

	public Date getAdTime() {
		return adTime;
	}

	public void setAdTime(Date adTime) {
		this.adTime = adTime;
	}

	public int getAdPriaseNum() {
		return adPriaseNum;
	}

	public void setAdPriaseNum(int adPriaseNum) {
		this.adPriaseNum = adPriaseNum;
	}
	
	
	
	

}
