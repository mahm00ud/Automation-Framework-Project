package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryPage extends PageBase{
    //Variables
    private WebDriver driver;

    //Constructor
    public OrderSummaryPage(WebDriver driver){
        super(driver);
        this.driver= driver;
    }

    //Elements
    private By confirmOrderBtn = By.xpath("//p[@id='cart_navigation']//button[@type='submit']");

    //Actions
    public ConfirmationPage clickOnConfirmOrder(){
        clickOnBtn(confirmOrderBtn);
        return new ConfirmationPage(driver);
    }

}
