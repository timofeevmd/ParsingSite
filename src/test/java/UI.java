import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Properties;

public class UI {
    ActionChrome actionChrome = new ActionChrome();
    ConnectionProperties cp = new ConnectionProperties();
    Properties property = cp.parsingPropertyFile();

    String firstName = property.getProperty("addDataFirstName");
    String firstCount = property.getProperty("addDataFirstCount");
    String firstPrice = property.getProperty("addDataFirstPrice");
    String delete = property.getProperty("linkDelete");

@BeforeTest
    public void initiateTest(){
        actionChrome.load();
    }

@Test
    public void linkDelete(){
        List<WebElement> tr = actionChrome.getTable();
        for(int i=tr.size()-1; i>=0; i--) {
            tr = actionChrome.getTable();
            WebElement we = tr.get(i).findElement(By.xpath(delete));
            we.click();
        }
        tr = actionChrome.getTable();
        Assert.assertTrue(tr.isEmpty(), "Table is empty");
    }

@Test
    public void addNewRow(){
        List<WebElement> tr = actionChrome.getTable();
        actionChrome.addRow(firstName, firstCount, firstPrice);
        List<WebElement> trUpDateTable = actionChrome.getTable();
        Assert.assertNotEquals(trUpDateTable.size(), tr.size(), "Row wos added to table.");
    }

@Test
    public void deleteAddedRow(){
        List<WebElement> tr = actionChrome.getTable();
        actionChrome.addRow(firstName, firstCount, firstPrice);
        WebElement linkDelete = actionChrome.driver.findElement(By.xpath(delete));
        linkDelete.click();
        List<WebElement> trUpDateTable = actionChrome.getTable();
        Assert.assertEquals(trUpDateTable.size(), tr.size(), "Row wos deleted to table.");
    }

@AfterTest
    public void closeSession(){
        actionChrome.close();
    }

}
