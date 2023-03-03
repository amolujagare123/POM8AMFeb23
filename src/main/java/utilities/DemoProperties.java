package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DemoProperties {

    public static void main(String[] args) throws IOException {
        // 1. read the file
        FileInputStream fis = new FileInputStream("Config/invoicePlane.properties");

        // 2. create the object of properties class
        Properties prop = new Properties();

        // 3. load this prop. object with fis (FileInputStream object)
        prop.load(fis);

        // 4. read the value of the key
        System.out.println(prop.getProperty("url"));
        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));
    }
}
