package test.service;

import javaBean.Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.PageService;

import java.util.List;

//import org.json.JSONObject;
/**
 * PageService Tester.
 *
 * @author <Authors name>
 * @since <pre>9, 15, 2018</pre>
 * @version 1.0
 */
public class PageServiceTest {
	
	@Before
	public void before() throws Exception {
	}
	
	@After
	public void after() throws Exception {
	}
	
	/**
	 *
	 * Method: getOnePageRecord(Page page)
	 *
	 */
	@Test
	public void testGetOnePageRecord() throws Exception {
//TODO: Test goes here...
		PageService pageService = new PageService();
		Page page = new Page();
//		page.setTy("next");
		page.setTableName("news");
		page.setPage(2);
		page.setPageSize(6);
		page.setOrderField("newsId");
		page.setOrder("ASC");
		List newsList = pageService.getOnePageRecord(page);

	}
	
} 
