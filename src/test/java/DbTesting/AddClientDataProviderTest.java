package DbTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static Util.Conversion.*;
import static utilities.ConfigReader.*;
import static utilities.DataProvider.getMyData;

public class AddClientDataProviderTest {
    WebDriver driver;
    @BeforeClass
    public void doLogin() throws IOException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(getUrl());

        Login login = new Login(driver);

        login.setTxtUsername(getUsername());
        login.setTxtPassword(getPassword());
        login.clickLogin();
    }

    @Test (dataProvider = "getData")
    public void addClientTest(String name,String surname,String language,
                              String address1,String address2,String city,
                              String state,String zip,String country,
                              String gender,String birthDate,String phone,
                              String fax,String mobile,String email,
                              String web,String tax,String vat) throws ClassNotFoundException, SQLException, ParseException {

        ArrayList<String> expected = new ArrayList<>();
        expected.add(name);
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(address1);
        expected.add(address2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(country);
        expected.add(gender);
        expected.add(birthDate);
        expected.add(phone);
        expected.add(fax);
        expected.add(mobile);
        expected.add(email);
        expected.add(web);
        expected.add(tax);
        expected.add(vat);



        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);


        addClient.setClientName(name);
        addClient.setClientSurname(surname);
        addClient.setLanguage(language);
        addClient.setClientAdd1(address1);
        addClient.setClientAdd2(address2);
        addClient.setClientCity(city);
        addClient.setClientState(state);
        addClient.setClientZip(zip);
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setBDate(birthDate);
        addClient.setClientPhone(phone);
        addClient.setClientFax(fax);
        addClient.setClientMobile(mobile);
        addClient.setClientEmail(email);
        addClient.setClientWeb(web);
        addClient.setClientTax(tax);
        addClient.setClientVat(vat);

        addClient.clickSave();

        // 1. loading a driver ( including jdbc library )
        Class.forName("com.mysql.jdbc.Driver");

        // 2. establish/creating connection
        String url = "jdbc:mysql://localhost:3306/ip";
        String username = "root";
        String password = "root";

        Connection con = DriverManager.getConnection(url,username,password);

        // 3. creating statement
        Statement st = con.createStatement();

        // 4. executing query
        String sql = "select * from ip_clients where client_name='"+name+"'";
        ResultSet rs = st.executeQuery(sql);
        ArrayList<String> actual = new ArrayList<>();

        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            actual.add(convertCountry(rs.getString("client_country")));



            actual.add(getGender(rs.getString("client_gender")));

           String convertedDate =  convertDate(rs.getString("client_birthdate"));

            actual.add(convertedDate); // MM/dd/yyyy



            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_tax_code"));
            actual.add(rs.getString("client_vat_id"));
        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"Some field are not matching");

    }

    @DataProvider
    public Object[][] getData() throws IOException {

        return getMyData("Data/addClient.xlsx","dbTesting");
    }
}
