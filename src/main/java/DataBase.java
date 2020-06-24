import objects.ObjectTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataBase {

    public List <ObjectTable> parsingAllRows (List<WebElement> rows){
        List<WebElement> td;
        List<ObjectTable> table = new ArrayList<>();
        for(int i=0; i<rows.size(); i++) {
            td = rows.get(i).findElements(By.tagName("td"));
            List<String> row = td.stream().map(elem -> elem.getText()).collect(Collectors.toList());
            ObjectTable objectTable1 = new ObjectTable(row.get(0), Integer.parseInt(row.get(1)), Integer.parseInt(row.get(2)), row.get(3));
            table.add(objectTable1);
        }
        return table;
    }

    public String parsingRow (WebElement we){
        WebElement td = we.findElement(By.tagName("tr"));

        return td.getText();
    }

    public ArrayList parsingHeaderDate (WebElement we){
        ArrayList element = new ArrayList();
        we.findElements(By.tagName("td")).forEach(elem -> element.add(elem.getText()));
        return element;
    }
}
