package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.regex.*;

public class OrderHistoryPage extends PageBase {

    //Variables
    private WebDriver driver;

    //Constructor
    public OrderHistoryPage(WebDriver driver){
        super(driver);
        this.driver= driver;
    }

    //Elements
    private By orderID1 = By.xpath("(//td[contains(@class,'footable-first-column')]/a)[1]");

    //Actions
    public void clickOnOrderID(){
        clickOnBtn(orderID1);
    }

    //Get order ID from Order history
    public String getLastOrderID(){
        return driver.findElement(orderID1).getText();
    }

    public void checkID(){
        Pattern.matches("\\S", "\n" +
                "\t\t\t\t\t\t\t\tOMJIPUKEH\n" +
                "\t\t\t\t\t\t\t");
    }
}
