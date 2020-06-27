import objects.ObjectTable;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;
import java.util.Properties;

public class AddData {
    static Hibernet hibernet = new Hibernet();
    static DataBase dataBase = new DataBase();
    ActionChrome actionChrome = new ActionChrome();
    ConnectionProperties cp = new ConnectionProperties();
    Properties property = cp.parsingPropertyFile();

    String firstName = property.getProperty("addDataFirstName");
    String firstCount = property.getProperty("addDataFirstCount");
    String firstPrice = property.getProperty("addDataFirstPrice");
    String secondName = property.getProperty("addDataSecondName");
    String secondCount = property.getProperty("addDataSecondCount");
    String secondPrice = property.getProperty("addDataSecondPrice");

    @Test
    public void addData(){
    actionChrome.load();
    List<WebElement> tr = actionChrome.getTable();
    List<ObjectTable> list = dataBase.parsingAllRows(tr);
    hibernet.initDataBase();
    hibernet.addData(list);
    List<ObjectTable> objectTable = hibernet.getData();
    actionChrome.addRow(firstName, firstCount, firstPrice);
    actionChrome.addRow(secondName, secondCount, secondPrice);
    List<WebElement> upDateTr = actionChrome.getTable();
    List<ObjectTable> upDateList = dataBase.parsingAllRows(upDateTr);
    Assert.assertNotEquals(objectTable, upDateList);
    upDateList.removeAll(objectTable);
    actionChrome.close();
    }
}
