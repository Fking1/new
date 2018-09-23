package test.tools; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import tools.EmailTool;

/** 
* EmailTool Tester. 
* 
* @author <Authors name> 
* @since <pre>9, 23, 2018</pre>
* @version 1.0 
*/ 
public class EmailToolTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: sendEmail(String to, String theme, String emailContent) 
* 
*/ 
@Test
public void testSendEmail() throws Exception { 
//TODO: Test goes here...
    EmailTool emailTool = new EmailTool();
    emailTool.sendEmail("455039690@qq.com","注册","点击完成注册"+"www.baidu.com");
} 

}