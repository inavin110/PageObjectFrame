package GenericAPI;

/**
 * Created by navinislam on 11/29/15.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by navinislam on 11/24/15.
 */
public class Base {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("gmail.com");
    }

    @AfterMethod

    public void quitDriver(){
        driver.quit();
    }

}
