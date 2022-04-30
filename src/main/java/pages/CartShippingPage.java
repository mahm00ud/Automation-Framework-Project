package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartShippingPage extends PageBase {

    //Variables
    private WebDriver driver;

    //Constructor
    public CartShippingPage(WebDriver driver){
        super(driver);
        this.driver= driver;
    }

    //Elements
    private By agreeCheckBox = By.id("cgv");
    private By proceedCheckoutBtn4 = By.name("processCarrier");

    //Actions
    public void agreeOnTerms(){
        driver.findElement(agreeCheckBox).click();
        //clickOnBtn(agreeCheckBox);
    }

    public CartPaymentPage clickOnProceedToCheckout4(){
        clickOnBtn(proceedCheckoutBtn4);
        return new CartPaymentPage(driver);
    }
}
