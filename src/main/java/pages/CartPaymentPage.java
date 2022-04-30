package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPaymentPage extends PageBase {
    //Variables
    private WebDriver driver;

    //Constructor
    public CartPaymentPage(WebDriver driver){
        super(driver);
        this.driver= driver;
    }

    //Elements
    private By PayBankWire = By.cssSelector("a[title='Pay by bank wire']");

    //Actions
    public void clickOnBankWire(){
        clickOnBtn(PayBankWire);
    }
}
