package service;

import dao.UserDao;
import javaBean.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	public static UserDao userDao;
	static {
		try {
			userDao = new UserDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Integer register(User user) throws Exception {
		if(userDao.searchUserByNameAndPassword(user).next()){
			return 0;
		}
		else{
			userDao.insertUser(user);
			return 1;
		}
	}
	
	public Boolean login(User user) throws Exception{
		ResultSet rs = userDao.searchUserByNameAndPassword(user);
		if(rs.next()){
			user.setUserId(rs.getString("userId"));
			user.setUserName(rs.getString("userName"));
			user.setPassword(rs.getString("password"));
			user.setUserType(rs.getInt("userType"));
			user.setRegisterDate(rs.getTimestamp("registerDate"));
			user.setEnable(rs.getString("enable"));
			user.setHeaderIconUrl(rs.getString("headerIconUrl"));
			return true;
		}
		else{
			return false;
		}
	}
	
	public User getUserById(String id) throws Exception {
		ResultSet rs = userDao.searchUserByAccurateId(id);
		User user = new User();
		while(rs.next()){
			user.setUserId(rs.getString("userId"));
			user.setUserName(rs.getString("userName"));
			user.setPassword(rs.getString("password"));
			user.setUserType(rs.getInt("userType"));
			user.setRegisterDate(rs.getTimestamp("registerDate"));
			user.setEnable(rs.getString("enable"));
			user.setHeaderIconUrl(rs.getString("headerIconUrl"));
		}
		return user;
	}
	
	public List<User> getUserListByName(String name) throws Exception {
		ResultSet rs = userDao.searchUserByPuzzyName(name);
		List<User> userList = new ArrayList<User>();
		User user = new User();
		while(rs.next()){
			user.setUserId(rs.getString("userId"));
			user.setUserName(rs.getString("userName"));
			user.setPassword(rs.getString("password"));
			user.setUserType(rs.getInt("userType"));
			user.setRegisterDate(rs.getTimestamp("registerDate"));
			user.setEnable(rs.getString("enable"));
			user.setHeaderIconUrl(rs.getString("headerIconUrl"));
			userList.add(user);
		}
		return userList;
	}
	
	public Integer updateUserInfo(User user) throws Exception{
		return userDao.updateUser(user);
	}

	public Integer completeRegister(User user) throws Exception {
	    return userDao.updateUserType(user);
    }
}
