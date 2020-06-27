import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Properties;

public class ActionChrome {
    ConnectionProperties cp = new ConnectionProperties();
    Properties property = cp.parsingPropertyFile();
    ChromeDriver driver;

    String getURL = property.getProperty("getConnectionURL");
    String tableOnSite = property.getProperty("getTableOnSite");
    String openForm = property.getProperty("openForm");
    String typeName = property.getProperty("typeName");
    String typeCount = property.getProperty("typeCount");
    String typePrice = property.getProperty("typePrice");
    String addButton = property.getProperty("addButton");

    public List<WebElement> getTable(){
        WebElement table = driver.findElement(By.xpath(tableOnSite));
        List<WebElement> tr = table.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        return tr;
    }

    public void addRow(String name, String count, String price){
        driver.findElement(By.xpath(openForm)).click();
        driver.findElement(By.xpath(typeName)).clear();
        driver.findElement(By.xpath(typeName)).sendKeys(name);
        driver.findElement(By.xpath(typeCount)).clear();
        driver.findElement(By.xpath(typeCount)).sendKeys(count);
        driver.findElement(By.xpath(typePrice)).clear();
        driver.findElement(By.xpath(typePrice)).sendKeys(price);
        driver.findElement(By.xpath(addButton)).click();
    }

    public void close(){
        driver.quit();
    }

    public void load(){
        System.setProperty("webdriver.chrome.driver" , "/Users/bardak/Documents/tools/chromedriver");
        driver = new ChromeDriver();
        driver.get(getURL);
    }
}
