import objects.ObjectTable;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ParsingSite {
    static Hibernet hibernet = new Hibernet();
    static DataBase dataBase = new DataBase();
    ActionChrome actionChrome = new ActionChrome();

    @Test
    public void parsingSite(){
        actionChrome.load();
        List<WebElement> tr = actionChrome.getTable();
        List<ObjectTable> list = dataBase.parsingAllRows(tr);
        hibernet.initDataBase();
        hibernet.addData(list);
        List<ObjectTable> data = hibernet.getData();
        Assert.assertEquals(list.get(0), data.get(0));
        actionChrome.close();
    }

}
