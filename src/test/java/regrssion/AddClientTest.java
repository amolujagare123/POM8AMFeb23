package regrssion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;

import java.io.IOException;

import static utilities.ConfigReader.*;

public class AddClientTest {
    WebDriver driver;
    @BeforeClass
    public void doLogin() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getUrl());

        Login login = new Login(driver);

        login.setTxtUsername(getUsername());
        login.setTxtPassword(getPassword());
        login.clickLogin();
    }

    @Test
    public void addClientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);




        addClient.setClientName("Sunil2");
        addClient.setClientSurname("Balina");
        addClient.setLanguage("English");
        addClient.setClientAdd1("xyz");
        addClient.setClientAdd2("abc");
        addClient.setClientCity("Bangalore");
        addClient.setClientState("kr");
        addClient.setClientZip("09090");
        addClient.setCountry("Mexico");
        addClient.setGender("Other");
        addClient.setBDate("03/21/2011");
        addClient.setClientPhone("111111");
        addClient.setClientFax("99090");
        addClient.setClientMobile("12357");
        addClient.setClientEmail("a@b.com");
        addClient.setClientWeb("www.xyz.com");
        addClient.setClientTax("12345");
        addClient.setClientVat("0987");

     addClient.clickSave();


    }
}
