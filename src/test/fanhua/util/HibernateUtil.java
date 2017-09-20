package test.fanhua.util;

public class HibernateUtil {
	
	static final ThreadLocal<Session> ThreadFac = new ThreadLocal<Session>();
	static SessionFactory sessionFac = null;
	
	static{
		sessionFac = SessionFactory.getInstance();
	}
	Session getSession(){
		Session s = ThreadFac.get();
		if(s == null ){
			s = sessionFac.getSession();
			ThreadFac.set(s);
		}
		return s;
	}
	
}

class SessionFactory{
	
	SessionFactory(){}
	private static SessionFactory factory;
	static SessionFactory getInstance(){
		if(factory == null){
			factory = new SessionFactory();
		}
		return factory;
	}
	
	public Session getSession(){
		Session s = new Session();
		return s;
	}
}

class Session{
	public void del(Object o){
		
	}
}
