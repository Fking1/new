package test.service;

import javaBean.News;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import service.NewsService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * NewsService Tester.
 *
 * @author <Authors name>
 * @since <pre>9, 15, 2018</pre>
 * @version 1.0
 */
public class NewsServiceTest {
	
	@Before
	public void before() throws Exception {
	}
	
	@After
	public void after() throws Exception {
	}
	
	/**
	 *
	 * Method: addNews(News news)
	 *
	 */
	@Test
	public void testAddNews() throws Exception {
//TODO: Test goes here...
		NewsService newsService = new NewsService();
		News news = new News();
		news.setCaption("在俄罗斯 听习近平讲昨天和今天的故事");
		news.setContent("[学习进行时]习近平担任中国国家主席以来多次访问俄罗斯，不管是出席第四届东方经济论坛、索契冬奥会开幕式，还是出席红场阅兵仪式、接受俄罗斯电视台采访，习近平都爱讲些动人的小故事。这些故事是中俄两国友好往来的生动例证。新华社《学习进行时》原创品牌栏目“讲习所”撷取其中的几则故事，与大家分享品味。\n" +
				"\n" +
				"　　习近平主席多次访问俄罗斯。在发表重要讲话、重要文章和接受记者采访时，他常深情地讲述一些动人的小故事。这些故事，是昨天和今天两国关系的缩影，更昭示了两国人民友谊的地久天长。");
		news.setOriginalUrl("http://news.sina.com.cn/c/xl/2018-09-16/doc-ifxeuwwr4847315.shtml");
		news.setNewsType("national");
		news.setAuthor("余鹏飞");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = sdf.format(new Date());
		news.setPublishDate(Timestamp.valueOf(d));
		newsService.addNews(news);
	}
	
	/**
	 *
	 * Method: removeNewsById(Integer id)
	 *
	 */
	@Test
	public void testRemoveNewsById() throws Exception {
//TODO: Test goes here...
	}
	
	/**
	 *
	 * Method: removeNewsByAuthor(String author)
	 *
	 */
	@Test
	public void testRemoveNewsByAuthor() throws Exception {
//TODO: Test goes here...
	}
	
	/**
	 *
	 * Method: getNewsById(Integer id)
	 *
	 */
	@Test
	public void testGetNewsById() throws Exception {
//TODO: Test goes here...
	}
	
	/**
	 *
	 * Method: getNewsByAccurateCaption(String caption)
	 *
	 */
	@Test
	public void testGetNewsByAccurateCaption() throws Exception {
//TODO: Test goes here...
	}
	
	/**
	 *
	 * Method: getNewsByPuzzyCaption(String caption)
	 *
	 */
	@Test
	public void testGetNewsByPuzzyCaption() throws Exception {
//TODO: Test goes here...
	}
	
	/**
	 *
	 * Method: getNewsByType(String type)
	 *
	 */
	@Test
	public void testGetNewsByType() throws Exception {
//TODO: Test goes here...
		NewsService newsService = new NewsService();
		List<News> newsList = newsService.getNewsByType("hot");
		for(int i=0; i<newsList.size(); i++){
			System.out.println(newsList.get(i).getNewsId());
		}
	}
	
	
} 
