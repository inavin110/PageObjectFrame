package PomFactory;

import Util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by navinislam on 11/26/15.
 */
public class GLogin {

    WebDriver driver;

    @FindBy (css = Constants.userNameBox)
    WebElement userName;

    @FindBy(css = Constants.passwordBox)
    WebElement passWord;

    @FindBy(css = Constants.nextButton)
    WebElement passBox;

    @FindBy (css = Constants.loginButton)
    WebElement loginBtn;

    public GLogin(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    public void setUserName(String strUser){
        userName.sendKeys(strUser);
    }
    public void setPassword(String strPassword){

        passWord.sendKeys(strPassword);

    }
    public void clickNext(){
        passBox.click();
    }
    public void clickSignIn(){
        loginBtn.submit();

    }
    public void loginToGUser(String strUserName){

        //Fill user name

        this.setUserName(strUserName);



        //Click next button

        this.clickNext();


    }
    public void loginToGPass( String strPass){
        //Fill password

        this.setPassword(strPass);

        //Click sign in

        this.clickSignIn();

    }

}
