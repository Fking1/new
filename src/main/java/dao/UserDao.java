package dao;
//整个UserDao中只做单一的功能 不涉及复杂过程
//复杂过程留给Service层解决
import javaBean.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	public static DatabaseDao databaseDao;
	
	static {
		try {
			databaseDao = new DatabaseDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//    增加用户数据模块
	public Integer insertUser(User user) throws Exception {
		String sql = "insert into user(userId,userName,password,mailAddress) values('"+
				user.getUserId()+"','"+
				user.getUserName()+"','"+
				user.getPassword()+"','"+
				user.getMailAddress()+"')";
		return databaseDao.update(sql);
	}
	
	//    删除用户数据模块
	public Integer deleteUserByAccurateId(String id) throws Exception {
		String sql = "delete from user where userId='"+id+"'";
		return databaseDao.update(sql);
	}
	public Integer deleteUserByAccurateName(String name) throws Exception {
		String sql = "delete from user where userName='"+name+"'";
		return databaseDao.update(sql);
	}
	public Integer deleteUserByFuzzyName(String name) throws Exception {
		String sql = "delete from user where userName like '%"+name+"%'";
		return databaseDao.update(sql);
	}
	
	//    查询用户数据模块
	public ResultSet searchUserByAccurateId(String id) throws Exception {
		String sql = "select * from user where userId='"+id+"'";
		return databaseDao.query(sql);
	}
	public ResultSet searchUserByAccurateName(String name) throws Exception {
		String sql = "select * from user where userName='"+name+"'";
		return databaseDao.query(sql);
	}
	public ResultSet searchUserByPuzzyName(String name) throws Exception {
		String sql = "select * from user where userName like '%"+name+"%'";
		return databaseDao.query(sql);
	}
	public ResultSet searchUserByNameAndPassword(User user) throws SQLException {
		String sql = "select * from user where userName='"+user.getUserName()+"' and password='"+user.getPassword()+"' and userType!=0";
		return databaseDao.query(sql);
	}
	//    修改用户数据模块
	public Integer updateUser(User user) throws Exception {
		String sql = "replace into user(userId,userName,password,userType,enable,headerIconUrl) values('"+
				user.getUserId()+"','"+
				user.getUserName()+"','"+
				user.getPassword()+"','"+
				user.getUserType()+"','"+
				user.getEnable()+"','"+
				user.getHeaderIconUrl()+"')";
		return databaseDao.update(sql);
	}

	public Integer updateUserType(User user) throws Exception {
	    String sql = "update user set userType=1 where userId='"+user.getUserId()+"'";
	    return databaseDao.update(sql);
    }
}
