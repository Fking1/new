package service;

import dao.NewsDao;
import javaBean.News;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsService {
	public static NewsDao newsDao;
	static {
		try {
			newsDao = new NewsDao();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Integer addNews(News news) throws Exception {
		newsDao.insertNews(news);
		return 1;
	}
	
	public Integer removeNewsById(Integer id) throws Exception {
		return newsDao.deleteNewsById(id);
	}
	public Integer removeNewsByAuthor(String author) throws Exception {
		return newsDao.deleteNewsByAuthor(author);
	}
	
	public News getNewsById(Integer id) throws Exception {
		News news = new News();
		ResultSet rs = newsDao.searchNewsById(id);
		while(rs.next()){
			news.setNewsId(rs.getInt("newsId"));
			news.setCaption(rs.getString("caption"));
			news.setContent(rs.getString("content"));
			news.setAuthor(rs.getString("author"));
			news.setNewsType(rs.getString("newsType"));
			news.setOriginalUrl(rs.getString("originalUrl"));
			news.setPublishDate(rs.getTimestamp("publishDate"));
		}
		return news;
	}
	public News getNewsByAccurateCaption(String caption) throws Exception {
		News news = new News();
		ResultSet rs = newsDao.searchNewsByAccurateCaption(caption);
		while(rs.next()){
			news.setNewsId(rs.getInt("newsId"));
			news.setCaption(rs.getString("caption"));
			news.setContent(rs.getString("content"));
			news.setAuthor(rs.getString("author"));
			news.setNewsType(rs.getString("newsType"));
			news.setOriginalUrl(rs.getString("originalUrl"));
			news.setPublishDate(rs.getTimestamp("publishDate"));
		}
		return news;
	}
	public List<News> getNewsByPuzzyCaption(String caption) throws  Exception {
		List<News> newsList = new ArrayList<News>();
		News news = new News();
		ResultSet rs = newsDao.searchNewsByPuzzyCaption(caption);
		while(rs.next()){
			news.setNewsId(rs.getInt("newsId"));
			news.setCaption(rs.getString("caption"));
			news.setContent(rs.getString("content"));
			news.setAuthor(rs.getString("author"));
			news.setNewsType(rs.getString("newsType"));
			news.setOriginalUrl(rs.getString("originalUrl"));
			news.setPublishDate(rs.getTimestamp("publishDate"));
		}
		return newsList;
	}
	public List<News> getNewsByType(String type) throws SQLException {
		List<News> newsList = new ArrayList<News>();
		ResultSet rs = newsDao.searchNewsByType(type);
		while(rs.next()){
			News news = new News();
			news.setNewsId(rs.getInt("newsId"));
			news.setCaption(rs.getString("caption"));
			news.setContent(rs.getString("content"));
			news.setAuthor(rs.getString("author"));
			news.setNewsType(rs.getString("newsType"));
			news.setOriginalUrl(rs.getString("originalUrl"));
			news.setPublishDate(rs.getTimestamp("publishDate"));
			newsList.add(news);
		}
		return newsList;
	}
}
