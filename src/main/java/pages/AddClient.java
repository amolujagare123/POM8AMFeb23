package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {
    @FindBy(xpath = "//input[@id='client_name']")
    WebElement clientName;

    public void setClientName(String name)
    {
      clientName.sendKeys(name);
    }

    @FindBy (xpath = "//input[@id='client_surname']")
    WebElement clientSurname;

    public void setClientSurname(String surname)
    {
        clientSurname.sendKeys(surname);
    }

    @FindBy (xpath = "//input[@id='client_address_1']")
    WebElement clientAdd1;

    public void setClientAdd1(String add1)
    {
        clientAdd1.sendKeys(add1);
    }

    @FindBy (xpath = "//input[@id='client_address_2']")
    WebElement clientAdd2;

    public void setClientAdd2(String add2)
    {
        clientAdd2.sendKeys(add2);
    }

    @FindBy (xpath = "//input[@id='client_city']")
    WebElement clientCity;

    public void setClientCity(String city)
    {
        clientAdd1.sendKeys(city);
    }


    @FindBy (xpath = "//input[@id='client_state']")
    WebElement clientState;

    public void setClientState(String state)
    {
        clientState.sendKeys(state);
    }

    @FindBy (xpath = "//input[@id='client_zip']")
    WebElement clientZip;

    public void setClientZip(String zip)
    {
        clientZip.sendKeys(zip);
    }

    @FindBy (xpath = "//input[@id='client_phone']")
    WebElement clientPhone;

    @FindBy (xpath = "//input[@id='client_fax']")
    WebElement   clientFax;

    @FindBy (xpath = "//input[@id='client_mobile']")
    WebElement clientMobile;

    @FindBy (xpath = "//input[@id='client_email']")
    WebElement clientEmail;

    @FindBy (xpath = "//input[@id='client_vat_id']")
    WebElement clientVat;

    @FindBy (xpath = "//input[@id='client_tax_code']")
    WebElement clientTax;

    @FindBy (xpath = "//button[@id='btn-submit']")
    WebElement btnSave;

    public void clickSave()
    {
        btnSave.click();
    }

    public AddClient(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

}
