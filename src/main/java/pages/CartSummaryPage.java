package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartSummaryPage extends PageBase {
    //Variables
    private WebDriver driver;

    //Constructor
    public CartSummaryPage(WebDriver driver){
        super(driver);
        this.driver= driver;
    }

    //Elements
    By proceedCheckoutBtn = By.xpath("//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']");

    //Actions
    public CartAddressPage clickOnProceedToCheckout1(){
        clickOnBtn(proceedCheckoutBtn);
        return new CartAddressPage(driver);

    }


}
