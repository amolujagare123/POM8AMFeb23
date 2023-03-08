package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

    @FindBy(xpath = "//a[@class='hidden-md']")
    WebElement dashBoard;

    @FindBy(xpath = "//span[normalize-space()='Clients']")
    WebElement clients;

    @FindBy(xpath = "//a[contains(text(),'Add Client')]")
    WebElement addClient;

    @FindBy(xpath = "//a[normalize-space()='View Clients']")
    WebElement viewClient;

    @FindBy(xpath = "//span[normalize-space()='Quotes']")
    WebElement quotes;

    @FindBy(xpath = "//a[@class='create-quote']")
    WebElement createQuote;

    @FindBy(xpath = "//a[normalize-space()='View Quotes']")
    WebElement viewQuote;

    public Menu(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void clickDashboard()
    {
        dashBoard.click();
    }

    public void clickAddClient()
    {
        clients.click();
        addClient.click();
    }
    public void viewClient()
    {
        clients.click();
        viewClient.click();
    }

    public void ClickCreateQuote()
    {
        quotes.click();
        createQuote.click();

    }
    public void ClickViewQuote()
    {
        quotes.click();
        viewQuote.click();

    }



}

