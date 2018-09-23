package dao;

import javaBean.News;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class NewsDao {
	public static DatabaseDao databaseDao;
	
	static {
		try {
			databaseDao = new DatabaseDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//    增加新闻模块
	public Integer insertNews(News news) throws SQLException {
		String sql = "insert into news(caption,content,newsType,author,originalUrl,publishDate) values('"+
				news.getCaption()+"','"+
				news.getContent()+"','"+
				news.getNewsType()+"','"+
				news.getAuthor()+"','"+
				news.getOriginalUrl()+"','"+
				news.getPublishDate()+"')";
		return databaseDao.update(sql);
	}
	
	
	//    删除新闻模块
	public Integer deleteNewsById(Integer id) throws Exception {
		String sql = "delete from news where newsId='"+id+"'";
		return databaseDao.update(sql);
	}
	public Integer deleteNewsByAccurateCaption(String caption) throws Exception {
		String sql = "delete from news where caption='"+caption+"'";
		return databaseDao.update(sql);
	}
	public Integer deleteNewsByPuzzyCaption(String caption) throws Exception {
		String sql = "delete from news where caption like '%"+caption+"%'";
		return databaseDao.update(sql);
	}
	public Integer deleteNewsByAuthor(String author) throws Exception {
		String sql = "delete from news where author='"+author+"'";
		return databaseDao.update(sql);
	}
	public Integer deleteNewsBeforeDate(Date date) throws Exception {
		String sql = "delete from news where publishDate < '"+date+"'";
		return databaseDao.update(sql);
	}
	
	//    查询新闻模块
	public ResultSet searchNewsById(Integer id) throws Exception {
		String sql = "select * from news where newsId='"+id+"'";
		return databaseDao.query(sql);
	}
	public ResultSet searchNewsByAccurateCaption(String caption) throws SQLException {
		String sql = "select * from news where caption='"+caption+"'";
		return databaseDao.query(sql);
	}
	public ResultSet searchNewsByPuzzyCaption(String caption) throws Exception {
		String sql = "select * from news where caption like '%"+caption+"%'";
		return databaseDao.query(sql);
	}
	public ResultSet searchNewsByAuthor(String author) throws SQLException {
		String sql = "select * from news where author='"+author+"'";
		return databaseDao.query(sql);
	}
	public ResultSet searchNewsByType(String type) throws SQLException {
		String sql = "select * from news where newsType='"+type+"'";
		return databaseDao.query(sql);
	}
}