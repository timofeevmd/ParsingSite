import objects.ObjectTable;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;


import java.util.List;

public class AddData {
    static Hibernet hibernet = new Hibernet();
    static DataBase dataBase = new DataBase();
    ActionChrome actionChrome = new ActionChrome();

@Test
    public void addData(){
    actionChrome.load();
    List<WebElement> tr = actionChrome.getTable();
    List<ObjectTable> list = dataBase.parsingAllRows(tr);
    hibernet.initDataBase();
    hibernet.addData(list);
    List<ObjectTable> objectTable = hibernet.getData();
    actionChrome.addRow("Галстук Черномырдина", "12", "15037");
    actionChrome.addRow("Попугай", "38", "31");
    List<WebElement> upDateTr = actionChrome.getTable();
    List<ObjectTable> upDateList = dataBase.parsingAllRows(upDateTr);
    Assert.assertNotEquals(objectTable, upDateList);
    upDateList.removeAll(objectTable);
    System.out.println(upDateList);
    actionChrome.close();
    }
}
