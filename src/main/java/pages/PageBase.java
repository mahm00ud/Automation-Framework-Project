package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageBase {

    //Variables
    private WebDriver driver;
    protected WebDriverWait wait;
    private Actions actions;

    //Constructor
    public PageBase(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.driver= driver;
    }


    //Actions
    public void clickOnBtn(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public void insertData(By element, String inputData){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(inputData);
    }

    public void hoverOver(By element){
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(element)).perform();
    }

    public String extratTextByPattern(String pattern, String sentence){
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(sentence);
        String extractedText = null;
        if (m.find( )) {
            extractedText = (m.group(0));
        }
        return extractedText;
    }

}
