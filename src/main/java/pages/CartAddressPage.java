package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartAddressPage extends PageBase {
    //Variables
    private WebDriver driver;

    //Constructor
    public CartAddressPage(WebDriver driver){
        super(driver);
        this.driver= driver;
    }

    //Elements
    private By proceedCheckoutBtn3 = By.name("processAddress");

    //Actions
    public CartShippingPage clickOnProceedToCheckout3(){
        clickOnBtn(proceedCheckoutBtn3);
        return new CartShippingPage(driver);
    }
}
