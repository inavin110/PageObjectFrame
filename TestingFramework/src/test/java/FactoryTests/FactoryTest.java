package FactoryTests;


import GenericAPI.Base;
import PomFactory.GHome;
import PomFactory.GLogin;
import Util.Constants;
import Util.ExcelUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by navinislam on 11/26/15.
 */
public class FactoryTest extends Base {

    GLogin objlogin;
    GHome objhome;

    Logger LOG= LogManager.getLogger();
    @Test(dataProvider="Authentication")
    public void pageFactTest(String username, String pass ) throws IOException {
        LOG.info("Logging in");
        objlogin=new GLogin(driver);
        objhome= new GHome(driver);
        LOG.info("Entering user");
        objlogin.loginToGUser(username);
        LOG.info("entering pass");
        objlogin.loginToGPass(pass);
        LOG.info("counting email");

        String emailCount= objhome.getInbxTxt();
        int num = emailCount.length();
        if(num>9){
            System.out.println("There is email");

        }

    }
    @DataProvider

    public Object[][] Authentication() throws Exception{

        Object[][] testObjArray = ExcelUtils.getTableArray(Constants.XcelPath, Constants.UserSheetName);

        return (testObjArray);

    }

}
