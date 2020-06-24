import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ActionChrome {

    ChromeDriver driver;

    public List<WebElement> getTable(){
        WebElement table = driver.findElement(By.xpath("//*[@id='tbl']"));
        List<WebElement> tr = table.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        return tr;
    }

    public void addRow(String name, String count, String price){
        driver.findElement(By.xpath("//*[@id='open']")).click();
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys(name);
        driver.findElement(By.xpath("//*[@id='count']")).sendKeys(count);
        driver.findElement(By.xpath("//*[@id='price']")).sendKeys(price);
        driver.findElement(By.xpath("//*[@id='add']")).click();
        driver.findElement(By.xpath("//*[@id='name']")).clear();
        driver.findElement(By.xpath("//*[@id='count']")).clear();
        driver.findElement(By.xpath("//*[@id='price']")).clear();
    }

    public void close(){
        driver.quit();
    }

    public void load(){
        System.setProperty("webdriver.chrome.driver" , "/Users/bardak/Documents/tools/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://checkme.kavichki.com");
    }
}
