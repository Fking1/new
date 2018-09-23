package dao;

import java.sql.*;

public class DatabaseDao {
	public static String drv="com.mysql.jdbc.Driver";
	public static String url="jdbc:mysql://118.89.38.84:3306/newssystem?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	public static String user="root";
	public static String password="123456";
	Connection connect = null;
	Statement stmt=null;
	ResultSet rs = null;
	
	public DatabaseDao()  throws Exception{
		try{
			Class.forName(drv);//载入JDBC驱动程序
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		try{
			connect = DriverManager.getConnection(url, user, password);//连接数据库
		}catch(SQLException e){
			e.printStackTrace();
		}
		stmt = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE,ResultSet.HOLD_CURSORS_OVER_COMMIT);
	}
	
	public ResultSet  query(String sql) throws SQLException{
		return stmt.executeQuery(sql);
	}//发送查询语句
	
	public int update(String sql) throws SQLException {
		return stmt.executeUpdate(sql);
	}//发送插入、删除及修改语句
	
	public boolean next() throws SQLException{
		return rs.next();
	}//rs的下一条记录是否存在
	
	public int getCount(String sql) throws SQLException{//查询符合条件的记录的数目
		ResultSet rs = query(sql);
		int i=0;
		while(rs.next()){
			i++;
		}
		return i;
	}
	
	public Connection getConnect() {
		return connect;
	}
	
	public void setConnect(Connection connect) {
		this.connect = connect;
	}
	
	public ResultSet getRs() {
		return rs;
	}
	
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	public void closeConnect() throws SQLException{
		connect.close();
	}
}