import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConnectionProperties {
    FileInputStream fileInputStream;

    public Properties parsingPropertyFile() {
        Properties property = new Properties();
        try {
            fileInputStream = new FileInputStream("src/main/resources/data.properties");
            property.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("Error: data.properties not found.");
        }
        return property;
    }
}
