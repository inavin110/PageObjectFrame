package Util;

import java.util.Hashtable;

/**
 * Created by navinislam on 11/26/15.
 */
public class TestUtils {
    public static Object[][] getData(String testName,DataRead xls){
        // find the row num from which test starts
        // number of cols in the test
        // number of rows
        // put the data in hastable and put hastable in array

        int testStartRowNum=0;
        // find the row num from which test starts
        for(int rNum=1;rNum<=xls.getRowCount("Test Data");rNum++){
            if(xls.getCellData("Test Data", 0, rNum).equals(testName)){
                testStartRowNum=rNum;
                break;
            }
        }
        System.out.println("Test "+ testName +" starts from "+ testStartRowNum);

        int colStartRowNum=testStartRowNum+1;
        int totalCols=0;
        while(!xls.getCellData("Test Data", totalCols, colStartRowNum).equals("")){
            totalCols++;
        }
        System.out.println("Total Cols in test "+ testName + " are "+ totalCols);

        //rows
        int dataStartRowNum=testStartRowNum+2;
        int totalRows=0;
        while(!xls.getCellData("Test Data", 0, dataStartRowNum+totalRows).equals("")){
            totalRows++;
        }
        System.out.println("Total Rows in test "+ testName + " are "+ totalRows);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        // extract data
        Object[][] data = new Object[totalRows][1];
        int index=0;
        Hashtable<String,String> table=null;
        for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+totalRows);rNum++){
            table = new Hashtable<String,String>();
            for(int cNum=0;cNum<totalCols;cNum++){
                table.put(xls.getCellData("Test Data", cNum, colStartRowNum), xls.getCellData("Test Data", cNum, rNum));
                System.out.print(xls.getCellData("Test Data", cNum, rNum) +" -- ");
            }
            data[index][0]= table;
            index++;
            System.out.println();
        }

        System.out.println("done");

        return data;
    }

}
