package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage  extends PageBase {

    //Variables
    private WebDriver driver;

    //Constructor
    public SignInPage(WebDriver driver){
        super(driver);
        this.driver= driver;
    }

    //Elements
    private By emailFieldSignUP = By.id("email_create");
    private By emailFieldLogin = By.id("email");
    private By passwordFieldLogin = By.id("passwd");
    private By createAccountBtn = By.id("SubmitCreate");
    private By signInBtn = By.id("SubmitLogin");

    //Actions

    //Insert Email
    public void insertEmail(String email){
        driver.findElement(emailFieldSignUP).sendKeys(email);
    }


    //Login
    public MyAccountPage login(String email, String password){
        insertData(emailFieldLogin, email);
        insertData(passwordFieldLogin, password);
        clickOnBtn(signInBtn);

        return new MyAccountPage(driver);
    }

    //Click on Create account Btn
    public CreateAccountPage clickOnCreateAccountBtn(){
        driver.findElement(createAccountBtn).click();
        return new CreateAccountPage(driver);
    }

}
