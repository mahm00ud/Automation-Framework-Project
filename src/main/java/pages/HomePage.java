package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HomePage extends PageBase {
    //Variables
    private WebDriver driver;

    //Constructor
    public HomePage(WebDriver driver){
        super(driver);
        this.driver= driver;
    }

    //Elements
    private By signInBtn = By.className("login");
    private By womenCategory = By.cssSelector("a[title='Women']");
    //private By blouses = By.xpath("//a[@class='product-name' and @title='Blouse']");
     private By blouses = By.cssSelector("a[title='Blouses']");
     private By customerAccountBtn= By.cssSelector("a[title='View my customer account']");
    Actions actions;

    //Actions
    public SignInPage clickOnSignInBtn(){
        driver.findElement(signInBtn).click();
            return new SignInPage(driver);
    }

    public MyAccountPage clickOnCustomerName(){
        clickOnBtn(customerAccountBtn);
        return new MyAccountPage(driver);
    }

    public void hoverOverWomen(){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(womenCategory)).perform();
    }

    public ProductPage clickOnBlouses(){
        clickOnBtn(blouses);
        return new ProductPage(driver);
    }






}
