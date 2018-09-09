package dao.imp;

import dao.IPostDao;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPostDao postDao =new PostDao();
		System.out.println(postDao.getMessageById(21));
	}

}
