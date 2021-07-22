package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass
{
     
     @Test(groups= {"regression", "master"})
     public void test_account_Registration()
     {
    	 try
    	 {
    	 logger.info("Starting TC_001_AccountRegistration");
    	 
    	 driver.get(rb.getString("appURL"));
    	 logger.info("opencart Application got opened");
    	 
    	 driver.manage().window().maximize();
    	 logger.info("Browser got maximized");
    	 
    	 HomePage hp =new HomePage(driver);
    	 hp.clickMyAccount();
    	 logger.info("Clicked on MyAccount");
    	 hp.clickRegister();
    	 logger.info("Register link got clicked");
    	 
    	 AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
    	 
    	 regpage.setFirstName("Kip");
    	 logger.info("Provided First Name");

    	 regpage.setLastName("Roe");
    	 logger.info("Provided Last Name");
    	 
    	 regpage.setEmail(randomeString()+"@gmail.com");
    	 logger.info("Provided Email");
    	 
    	 regpage.setTelephone("70162877");
    	 logger.info("Provided Telephone");
    	 
    	 regpage.setPassword("test@123");
    	 logger.info("Provided Password");
    	 
    	 regpage.setConfirmPassword("test@123");
    	 logger.info("Provided Confirm Password");
    	 
    	 regpage.setPrivacyPolicy();
    	 logger.info("Agreed privacy policy");
    	 
         regpage.ClickContinue();
         logger.info("Continue link got clicked");
         
         String confmsg = regpage.getConfirmationMsg();
         logger.info("Confirmation message captured");
         
         if(confmsg.equals("Your Account Has Been Created!"))
         {
        	 logger.info("Success: User Registered");
        	 Assert.assertTrue(true);
         }
         else
         {
        	 logger.error("Error: User Not Registered");
        	 captureScreen(driver, "test_account_Registration");
        	 Assert.assertTrue(false);
         }
    	 }
    	 catch(Exception e)
    	 {
    		 logger.error("Error: User Not Registered");
        	 Assert.fail();
    	 }
         
         logger.info("Finished TC_001_AccountRegistration");
         
     }
         
     
}
