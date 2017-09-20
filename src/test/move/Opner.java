package test.move;

import java.util.ArrayList;
import java.util.List;

public class Opner {
	List<User> users = new ArrayList<User>(6);
	public Opner() {
		for(int i=0;i<6;i++){
			User u = new User();
			u.setIndex(i);
			u.setName("name"+i);
			u.setuId(10+i);
			users.add(u);
		}
	}

	public void up(Integer uid){
		Integer old_index = 0;
		for(User u:users){
			if(u.getuId() == uid){
			    old_index = u.getIndex();
			    for(User u_:users){
					if(u_.getIndex() == old_index+1){
						u_.setIndex(old_index);
					}
				}
				u.setIndex(old_index+1);
			}
		}
	}

	public void down(){
		
	}
	
	public void outList(){
		for(User u:users){
			System.out.println(u.getuId()+": " +u.getIndex());
		}
	}
	
	public static void main(String[] args) {
		Opner opner = new Opner();
		opner.up(14);
		opner.outList();
	}
	
	
}




