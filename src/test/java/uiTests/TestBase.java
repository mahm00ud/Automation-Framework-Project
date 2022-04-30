package uiTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.DataReader;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;

    protected HomePage homePage;
    protected SignInPage signinPage;
    protected CreateAccountPage createAccountPage;
    protected MyAccountPage myAccountPage;
    protected ProductPage productPage;
    protected OrderHistoryPage orderHistoryPage;
    protected ConfirmationPage confirmationPage;
    protected CartSummaryPage cartSummaryPage;
    protected CartAddressPage cartAddressPage;
    protected CartPaymentPage cartPaymentPage;
    protected CartShippingPage cartShippingPage;
    protected OrderSummaryPage orderSummaryPage;
    protected DataReader dataReader;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(dataReader.getExcelValueByAttribute("URLs", "HomePage"));
        homePage = new HomePage(driver);
        signinPage = new SignInPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        myAccountPage = new MyAccountPage(driver);
        productPage = new ProductPage(driver);
        orderHistoryPage = new OrderHistoryPage(driver);
        confirmationPage = new ConfirmationPage(driver);
        cartSummaryPage = new CartSummaryPage(driver);
        cartAddressPage = new CartAddressPage(driver);
        cartPaymentPage = new CartPaymentPage(driver);
        cartShippingPage = new CartShippingPage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);

        dataReader = new DataReader();
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
