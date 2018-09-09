package bean;

import java.util.Date;

public class User {
	private int uId;        	//用户
	private String uName;    	//用户名
	private String uPass;		//用户密码
	private String uSex;		//用户性别
	private Date regTime; 		//注册时间
	private Date loginTime;		//登陆时间
	private String uEmail;		//用户邮箱
	private String uPhone;		//用户电话
	private String uImage;		//用户头像
	private String uSign;		//用户签到
	private int uPost;			//用户发帖量
	private int uCollect;		//用户收藏帖量
	private int uAtte;			//用户关注
	private int uFans;			//用户粉丝量
	private int uRank;			//用户等级
	private String uNickName;   //昵称
	private String uSignName;   //签名
	private String uCity;       //所在城市
	
	public User() {
		super();
	}

	public User(String uName, String uPass) {
		super();
		this.uName = uName;
		this.uPass = uPass;
	}

	public User(String uName, String uPass, String uImage) {
		this.uName = uName;
		this.uPass = uPass;
		this.uImage = uImage;
	}

	public User(int uId, String uName, String uPass) {
		super();
		this.uId=uId;
		this.uName = uName;
		this.uPass = uPass;
	}

	public User(int uId, String uName, String uPass, String uSex, Date regTime, Date loginTime, String uEmail, String uPhone, int uPost, int uCollect, int uAtte, int uFans, int uRank, String uNickName, String uCity) {
		this.uId = uId;
		this.uName = uName;
		this.uPass = uPass;
		this.uSex = uSex;
		this.regTime = regTime;
		this.loginTime = loginTime;
		this.uEmail = uEmail;
		this.uPhone = uPhone;
		this.uPost = uPost;
		this.uCollect = uCollect;
		this.uAtte = uAtte;
		this.uFans = uFans;
		this.uRank = uRank;
		this.uNickName = uNickName;
		this.uCity = uCity;
	}

	/**
	 * jyz，修改session
	 */
	public User(int uId, String uName, String uPass, String uSex, String uEmail, String uNickName, String uSignName,
			String uCity) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPass = uPass;
		this.uSex = uSex;
		this.uEmail = uEmail;
		this.uNickName = uNickName;
		this.uSignName = uSignName;
		this.uCity = uCity;
	}
	
	/**
	 * sss新增构造方法,session user对象放的是这些
	 * */

	public User(int uId, String uName, String uPass, String uSex, String uEmail, String uNickName, String uSignName,
			String uCity, Date regTime) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPass = uPass;
		this.uSex = uSex;
		this.uEmail = uEmail;
		this.uNickName = uNickName;
		this.uSignName = uSignName;
		this.uCity = uCity;
		this.regTime=regTime;
	}
	
	/**
	 * 共一个
	 * 前端修改用户信息用，修改性别，邮箱，昵称，签名，所在城市
	 * @param uId
	 * @param uSex
	 * @param uEmail
	 * @param uNickName
	 * @param uSignName
	 * @param uCity
	 */
	public User(int uId, String uSex, String uEmail, String uNickName, String uSignName, String uCity) {
		super();
		this.uId = uId;
		this.uSex = uSex;
		this.uEmail = uEmail;
		this.uNickName = uNickName;
		this.uSignName = uSignName;
		this.uCity = uCity;
	}
	
	
	
	public User(int uId, String uName, String uPass, String uSex, Date regTime, Date loginTime, String uEmail,
			String uPhone, String uImage, String uSign, int uPost, int uCollect, int uAtte, int uFans, int uRank) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPass = uPass;
		this.uSex = uSex;
		this.regTime = regTime;
		this.loginTime = loginTime;
		this.uEmail = uEmail;
		this.uPhone = uPhone;
		this.uImage = uImage;
		this.uSign = uSign;
		this.uPost = uPost;
		this.uCollect = uCollect;
		this.uAtte = uAtte;
		this.uFans = uFans;
		this.uRank = uRank;
	}

	public  User(String uName) {
		this.uName = uName;
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

	public String getuPass() {
		return uPass;
	}

	public void setuPass(String uPass) {
		this.uPass = uPass;
	}

	public String getuSex() {
		return uSex;
	}

	public void setuSex(String uSex) {
		this.uSex = uSex;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public String getuImage() {
		return uImage;
	}

	public void setuImage(String uImage) {
		this.uImage = uImage;
	}

	public int getuPost() {
		return uPost;
	}

	public void setuPost(int uPost) {
		this.uPost = uPost;
	}

	public int getuCollect() {
		return uCollect;
	}

	public void setuCollect(int uCollect) {
		this.uCollect = uCollect;
	}

	public int getuRank() {
		return uRank;
	}

	public void setuRank(int uRank) {
		this.uRank = uRank;
	}

	public int getuFans() {
		return uFans;
	}

	public void setuFans(int uFans) {
		this.uFans = uFans;
	}
	

	public String getuSign() {
		return uSign;
	}

	public void setuSign(String uSign) {
		this.uSign = uSign;
	}

	public int getuAtte() {
		return uAtte;
	}

	public void setuAtte(int uAtte) {
		this.uAtte = uAtte;
	}

	public String getuNickName() {
		return uNickName;
	}

	public void setuNickName(String uNickName) {
		this.uNickName = uNickName;
	}

	public String getuSignName() {
		return uSignName;
	}

	public void setuSignName(String uSignName) {
		this.uSignName = uSignName;
	}

	public String getuCity() {
		return uCity;
	}

	public void setuCity(String uCity) {
		this.uCity = uCity;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uPass=" + uPass + ", uSex=" + uSex + ", regTime=" + regTime
				+ ", loginTime=" + loginTime + ", uEmail=" + uEmail + ", uPhone=" + uPhone + ", uImage=" + uImage
				+ ", uPost=" + uPost + ", uCollect=" + uCollect + ", uRank=" + uRank + ", uFans=" + uFans + "]";
	}
	
	

	
	
	

}
