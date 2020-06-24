import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UI {
    ActionChrome actionChrome = new ActionChrome();

    @Test
    public void linkDelete(){
       actionChrome.load();
        List<WebElement> tr = actionChrome.getTable();
        for(int i=tr.size()-1; i>=0; i--) {
            tr = actionChrome.getTable();
            WebElement we = tr.get(i).findElement(By.xpath("//*[@class='delete']"));
            we.click();
        }
        tr = actionChrome.getTable();
        actionChrome.close();
        Assert.assertTrue("Table is empty",tr.isEmpty());
    }

    @Test
    public void addNewRow(){
        actionChrome.load();
        List<WebElement> tr = actionChrome.getTable();
        actionChrome.addRow("Галстук Черномырдина", "12", "15037");
        List<WebElement> trUpDateTable = actionChrome.getTable();
        actionChrome.close();
        Assert.assertNotEquals("Row wos added to table.",trUpDateTable.size(), tr.size());
    }

@Test
    public void deleteAddedRow(){
        actionChrome.load();
        List<WebElement> tr = actionChrome.getTable();
        actionChrome.addRow("Галстук Черномырдина", "12", "15037");
        WebElement linkDelete = actionChrome.driver.findElement(By.xpath("//*[@class='delete']"));
        linkDelete.click();
        List<WebElement> trUpDateTable = actionChrome.getTable();
        Assert.assertEquals("Row wos deleted to table.",trUpDateTable.size(), tr.size());
        actionChrome.close();
    }
}
