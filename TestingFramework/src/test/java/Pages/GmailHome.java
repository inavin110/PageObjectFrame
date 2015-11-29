package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by navinislam on 11/24/15.
 */
public class GmailHome   {

    WebDriver driver;
    By emailNumber= By.partialLinkText("Inbox");

    public GmailHome(WebDriver driver){
        this.driver= driver;
    }

    public String getInboxText(){
        return driver.findElement(emailNumber).getText();

    }


}
