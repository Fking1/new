package javaBean;

import java.sql.Timestamp;
import java.util.Date;

public class News {
	private Integer newsId; //新闻编号
	private String caption;//新闻标题
	private String content;//新闻内容
	private String newsType;//新闻类型
	private String author;//新闻作者
	private String originalUrl;//新闻来源
	private Timestamp publishDate; //新闻发布日期
	
	public Integer getNewsId() {
		return newsId;
	}
	
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	
	public String getCaption() {
		return caption;
	}
	
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getNewsType() {
		return newsType;
	}
	
	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getOriginalUrl() {
		return originalUrl;
	}
	
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	
	public Timestamp getPublishDate() {
		return publishDate;
	}
	
	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}
}
