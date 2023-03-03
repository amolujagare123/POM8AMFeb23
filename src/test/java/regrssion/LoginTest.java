package regrssion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Login;

import java.io.IOException;

import static utilities.ConfigReader.*;

public class LoginTest {

    @Test
    public void loginTest() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.get("http://localhost/ip");
        driver.get(getUrl());

        Login login = new Login(driver);

        login.setTxtUsername(getUsername());
        login.setTxtPassword(getPassword());
        login.clickLogin();
    }
}
