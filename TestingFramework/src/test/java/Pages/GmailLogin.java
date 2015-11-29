package Pages;

import Util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by navinislam on 11/24/15.
 */
public class GmailLogin {
    WebDriver driver;
    By userName= By.cssSelector(Constants.userNameBox);
    By userPass= By.cssSelector(Constants.passwordBox);
    By nxtBtn= By.cssSelector(Constants.nextButton);
    By signIn= By.cssSelector(Constants.loginButton);

    public GmailLogin(WebDriver driver){
        this.driver=driver;
    }
    public void setUserName(String strUser){
        driver.findElement(userName).sendKeys(strUser);

    }
    public void setPassword(String strPassword){

        driver.findElement(userPass).sendKeys(strPassword);

    }
    public void clickNext(){
        driver.findElement(nxtBtn).click();
    }
    public void clickSignIn(){
        driver.findElement(signIn).click();
    }
    public void loginToGmailUser(String strUserName){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password


        //Click next button

        this.clickNext();
        //Click sign in


    }
    public void loginToGmailPass( String strPass){
        this.setPassword(strPass);
        this.clickSignIn();

    }

}
