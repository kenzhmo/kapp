package service.impl;

import java.util.List;
import com.kapp.pojo.User;
import service.UserManagerService;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service("userManagerService")
public class UserManagerServiceImpl implements UserManagerService {

	private SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<User> getAllUser() {
		 Query query = this.sessionFactory.getCurrentSession().createQuery("from User");
		    @SuppressWarnings("unchecked")
			List<User> userlist = query.list();
		    return userlist;
	}

	@Override
	public User getUser(String userId) {
		int userIdInt = Integer.valueOf(userId).intValue();
		User user = (User)this.sessionFactory.getCurrentSession().get(User.class, userIdInt);
		return user;
	}

}
