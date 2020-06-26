import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConnectionProperties {

    FileInputStream fis;
    Properties property = new Properties();

    public void connectionProperty() {
        try {
            fis = new FileInputStream("src/main/resources/date.properties");
            property.load(fis);

        } catch (
                IOException e) {
            System.err.println("ERROR! File .properties is not define.");
        }
    }
}
