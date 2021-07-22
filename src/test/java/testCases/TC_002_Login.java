package testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass
{
    @Test(groups= {"sanity", "master"})
	public void test_login() 
	{
		logger.info("Starting TC_002_Login");
		
		try {
		driver.get(rb.getString("appURL"));
		logger.info("opencart Application got opened");
   	 
   	    driver.manage().window().maximize();
   	    logger.info("Browser got maximized");
   	    
   	    HomePage hp = new HomePage(driver);
   	    hp.clickMyAccount();
   	    logger.info("Clicked on MyAccount");
   	    hp.clickLogin();
   	    logger.info("Login link got clicked");
   	    
   	    LoginPage lp = new LoginPage(driver);
   	    
   	    lp.setEmail(rb.getString("email"));
   	    logger.info("Provided Email");
   	    
   	    lp.setPassword(rb.getString("password"));
   	    logger.info("Provided Password");
   	    
   	    lp.clickLogin();
   	    logger.info("Clicked on Login");
   	    
   	    boolean targetpage = lp.isMyAccountPageExists();
   	    
   	    if(targetpage)
   	    {
   	    	logger.info("Login Success");
   	    	Assert.assertTrue(true);
   	    }
   	    else
   	    {
   	    	logger.error("Login Failed");
   	    	captureScreen(driver,"test_login");  //Capturing Screen
   	    	Assert.assertTrue(false);
   	    }
		}
		catch(Exception e)
		{
			logger.fatal("Login Failed");
			Assert.fail();
		}
		
		logger.info("Finished TC_002_Login");
	}
}
