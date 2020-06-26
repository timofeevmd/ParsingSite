import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Properties;

public class UI {
    ActionChrome actionChrome = new ActionChrome();
    ConnectionProperties cp = new ConnectionProperties();
    Properties property = new Properties();

    String firstName = property.getProperty("addDataFirstName");
    String firstCount = property.getProperty("addDataFirstCount");
    String firstPrice = property.getProperty("addDataFirstPrice");
    String delete = property.getProperty("linkDelete");;

@Test
    public void linkDelete(){
       actionChrome.load();
        List<WebElement> tr = actionChrome.getTable();
        for(int i=tr.size()-1; i>=0; i--) {
            tr = actionChrome.getTable();
            WebElement we = tr.get(i).findElement(By.xpath(delete));
            we.click();
        }
        tr = actionChrome.getTable();
        actionChrome.close();
        Assert.assertTrue("Table is empty",tr.isEmpty());
    }

@Test
    public void addNewRow(){
        actionChrome.load();
        cp.connectionProperty();
        List<WebElement> tr = actionChrome.getTable();
        actionChrome.addRow(firstName, firstCount, firstPrice);
        List<WebElement> trUpDateTable = actionChrome.getTable();
        actionChrome.close();
        Assert.assertNotEquals("Row wos added to table.",trUpDateTable.size(), tr.size());
    }

@Test
    public void deleteAddedRow(){
        actionChrome.load();
        cp.connectionProperty();
        List<WebElement> tr = actionChrome.getTable();
        actionChrome.addRow(firstName, firstCount, firstPrice);
        WebElement linkDelete = actionChrome.driver.findElement(By.xpath(delete));
        linkDelete.click();
        List<WebElement> trUpDateTable = actionChrome.getTable();
        Assert.assertEquals("Row wos deleted to table.",trUpDateTable.size(), tr.size());
        actionChrome.close();
    }

}
