package designed.observer.test;

import java.util.Observable;

import designed.adpub.user.AdminUser;

public class UserDao extends Observable{
	
	private static UserDao userDao;
	public static UserDao getOb(){
		userDao = new UserDao();
		return userDao;
	}
	
	public void save(){
		this.setChanged();
		AdminUser admin = new AdminUser();
		this.notifyObservers(admin);
		System.out.println("save user");
	}
	
	public static void main(String[] args) {
		TransactionOb tran = new TransactionOb();
		UserDao ob = UserDao.getOb();
		ob.addObserver(tran);
		ob.save();
	}
}
