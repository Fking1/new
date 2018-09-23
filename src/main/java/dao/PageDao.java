package dao;

import javaBean.Page;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PageDao {
	public static DatabaseDao databaseDao;
	
	static {
		try {
			databaseDao = new DatabaseDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//    设置searchSql语句
	public void getSql(Page page){
		String sql = "select * from "+page.getTableName()+" where 1=1 "+page.getCondition()+" order by "+page.getOrderField()+" "+page.getOrder();
		System.out.println(sql);
		page.setSearchSql(sql);
	}
	//    设置搜索结果集
	public ResultSet getList(Page page) throws SQLException {
		page.setResult(true);
		return databaseDao.query(page.getSearchSql());
	}
	//    设置总记录数
	public void getTotalRecordCount(Page page) throws SQLException {
		page.setTotalRecordCount(databaseDao.getCount(page.getSearchSql()));
	}
	//    设置总页数
	public void getTotalPageCount(Page page) throws SQLException {
		if(databaseDao.getCount(page.getSearchSql())%page.getPageSize()==0){
			page.setTotalPageCount(databaseDao.getCount(page.getSearchSql())/page.getPageSize());
		}
		else{
			page.setTotalPageCount(databaseDao.getCount(page.getSearchSql())/page.getPageSize()+1);
		}
	}
	
}
