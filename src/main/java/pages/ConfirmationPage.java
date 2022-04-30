package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class ConfirmationPage extends PageBase {

    //Variables
    private WebDriver driver;

    //Constructor
    public ConfirmationPage(WebDriver driver){
        super(driver);
        this.driver= driver;
    }

    //Elements
    By confirmationMsg = By.xpath("//strong[(text()='Your order on My Store is complete.')]");
    By orderReference = By.xpath("//br[contains(text(),'Do not forget to insert your order reference')]");
    By orderReference2 = By.xpath("//*[@id='center_column']/div/text()[6]");
    By nameBank = By.xpath("//div[@class='box']/strong[3]");
    By boxMsg = By.className("box");


    //Actions
    public String getConfirmationText(){
        return driver.findElement(confirmationMsg).getText();
    }

    //Get order ID that is below Bank name
    public String getOrderIdByBankName(){
       return driver.findElement(with(By.tagName("br")).below(driver.findElement(nameBank))).getText();
    }

    //get Box msg
    public String getBoxMsg(){
        return driver.findElement(boxMsg).getText();
    }

    //Get OrderIdFrom confirmation Page
    public String getOrderID(){
        String[] lines = getBoxMsg().split("\r?\n");
        String orderReferenceLine = lines[6];
       return extratTextByPattern("(?<=reference\\s).*(?=\\sin the)",orderReferenceLine);
    }



}
