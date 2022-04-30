package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends PageBase {

    //Variables
    private WebDriver driver;

    //Constructor
    public ProductPage(WebDriver driver){
        super(driver);
        this.driver= driver;
    }

    //Elements
   // private By addtoCartBtn = By.id("add_to_cart");
    private By addtoCartBtn = By.cssSelector("a[title='Add to cart']");
    private By proceedToCheckoutBtn = By.cssSelector("a[title='Proceed to checkout']");
    private By blouses = By.xpath("//a[@class='product-name' and @title='Blouse']");
    private By addedToCartMsg = By.xpath("//h2[contains(.,'successfully added to')]");
    //Actions
    public void addProductToCart(){
        clickOnBtn(addtoCartBtn);
    }

    public void hoverOverBlouse(){
        hoverOver(blouses);
    }

    public CartSummaryPage clickOnCheckout(){
        clickOnBtn(proceedToCheckoutBtn);
        return new CartSummaryPage(driver);
    }

    public String getAddToCartMsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addedToCartMsg));
        return driver.findElement(addedToCartMsg).getText();
    }


}
