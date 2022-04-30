package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends PageBase {

    //Variables
    private WebDriver driver;

    //Constructor
    public MyAccountPage(WebDriver driver){
        super(driver);
        this.driver= driver;
    }

    //Elements
    private By welcomeMsg = By.className("info-account");
    private By orderHistoryBtn = By.cssSelector("a[title='Orders']");


    //Actions
    public String getWelcomeMsg(){
        return driver.findElement(welcomeMsg).getText();
    }

    public OrderHistoryPage clickOnOrderHistory(){
        clickOnBtn(orderHistoryBtn);
        return new OrderHistoryPage(driver);
    }
}
