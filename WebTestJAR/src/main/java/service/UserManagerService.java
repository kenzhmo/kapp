package service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kapp.pojo.User;

@Service("userManagerService")
public interface UserManagerService {
	
	List<User> getAllUser();
	
	User getUser(String userId);

}
