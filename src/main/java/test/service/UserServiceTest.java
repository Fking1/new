package test.service;

import javaBean.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.UserService;

import static org.junit.Assert.assertEquals;

/**
 * UserService Tester.
 *
 * @author <Authors name>
 * @since <pre>9, 14, 2018</pre>
 * @version 1.0
 */
public class UserServiceTest {
	
	@Before
	public void before() throws Exception {
	}
	
	@After
	public void after() throws Exception {
	}
	
	/**
	 *
	 * Method: register(User user)
	 *
	 */
	@Test
	public void testRegister() throws Exception {
//TODO: Test goes here...
		//System.currentTimeMillis() 和new Date().getTime()均可获取当前时间的时间戳
		UserService userService = new UserService();
		User user = new User();
		user.setUserId(String.valueOf(System.currentTimeMillis()));
		user.setUserName("zhongbin");
		user.setPassword("38362832");
		System.out.println(userService.register(user));
	}
	
	/**
	 *
	 * Method: login(User user)
	 *
	 */
	@Test
	public void testLogin() throws Exception {
//TODO: Test goes here...
		UserService userService = new UserService();
		User user = new User();
		user.setUserName("litaibai1");
		user.setPassword("libai123");
		System.out.println(userService.login(user));
	}
	
	/**
	 *
	 * Method: getUserListById(String id)
	 *
	 */
	@Test
	public void testGetUserListById() throws Exception {
//TODO: Test goes here...
		UserService userService = new UserService();
		User user = new User();
		assertEquals("litinghui", userService.getUserById("1537461993501").getUserName());
	}
	
	/**
	 *
	 * Method: getUserListByName(String name)
	 *
	 */
	@Test
	public void testGetUserListByName() throws Exception {
//TODO: Test goes here...
		UserService userService = new UserService();
		User user = new User();
		assertEquals(2,userService.getUserListByName("fan").toArray().length);
	}
	
	
	/**
	 *
	 * Method: updateUserInfo(User user)
	 *
	 */
	@Test
	public void testUpdateUserInfo() throws Exception {
//TODO: Test goes here...
		UserService userService = new UserService();
		User user = new User();
		user.setUserId("1536917202156");
		user.setUserName("fangyongs");
		user.setPassword("12343456");
		user.setUserType(0);
		user.setEnable("enable");
		user.setHeaderIconUrl("https://fangqcloud.club/images/icon.jpg");
		assertEquals("2",String.valueOf(userService.updateUserInfo(user)));
	}
	
	
}