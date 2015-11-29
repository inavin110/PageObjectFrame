package FactoryTests;

import GenericAPI.Base;
import Pages.GmailHome;
import Pages.GmailLogin;
import Util.ExcelUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by navinislam on 11/24/15.
 */
public class TestLogin extends Base {

    GmailLogin objLogin;
    GmailHome objHome;
    Logger LOG =LogManager.getLogger();

    @Test(dataProvider="Authentication")
    public void loginTest(String userName, String passWord) throws IOException {
        LOG.debug("Logging in");
        objLogin= new GmailLogin(driver);
        LOG.debug("Setting username");

        objLogin.loginToGmailUser(userName);
        LOG.debug("Setting password");
        objLogin.loginToGmailPass(passWord);


        objHome= new GmailHome(driver);

        LOG.debug("Checking email");
        String inboxText =objHome.getInboxText();

        Integer num = inboxText.length();
        if(num>8){
            System.out.println("There is email");

        }
        driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div[7]/div/div[1]/div[2]/div/table/tbody/tr[1]/td[4]/div[2]/span")).click();
        String email= driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/table/tr/td[1]/div[2]/div[2]/div/div[3]/div/div/div/div/div/div[1]")).getText();
        LOG.info("Asserting email containts Test123");
        Assert.assertTrue(email.contains("Test123"));
        //Make a constant
        LOG.info("Asserted true");
    }
    @DataProvider

    public Object[][] Authentication() throws Exception{


        Object[][] testObjArray = ExcelUtils.getTableArray("TestingFramework/src/Users.xlsx", "Users");

        return (testObjArray);

    }
}
