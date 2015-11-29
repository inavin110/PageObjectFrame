package PomFactory;

import Util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by navinislam on 11/26/15.
 */
public class GHome {

    WebDriver driver;

    @FindBy (partialLinkText = Constants.email)
    WebElement inbx;

    public GHome(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String getInbxTxt(){
        return inbx.getText();

    }



}
