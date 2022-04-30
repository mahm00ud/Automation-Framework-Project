package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends PageBase{

    //Variables
    private WebDriver driver;
    private Select drpDay;
    private Select drpMonth;
    private Select drpYear;
    private Select drpState;
    private Select drpCountry;

    //Constructor
    public CreateAccountPage(WebDriver driver){
        super(driver);
        this.driver= driver;
    }

    //Elements
    //YOUR PERSONAL INFORMATION
    private By mrBtn= By.id("id_gender1");
    private By mrsBtn= By.id("id_gender2");
    private By firstNameField = By.id("customer_firstname");
    private By lastNameField = By.id("customer_lastname");
    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    //Date of Birth
    private By daysDropDownList = By.id("days");
    private By monthsDropDownList = By.id("months");
    private By yearsDropDownList = By.id("years");


    //YOUR ADDRESS
    private By address1Field = By.id("address1");
    private By cityField = By.id("city");
    private By stateDropDownList = By.id("id_state");
    private By postalCodeField = By.id("postcode");
    private By countryDropDownList = By.id("id_country");
    private By mobField = By.id("phone_mobile");
    private By addressAlias = By.id("alias");

    private By submitBtn = By.id("submitAccount");

    //Actions

    //Select Gender
    public void selectGender(String gender){

        if(gender.equalsIgnoreCase("mr")){
            driver.findElement(mrBtn).click();
        }
        else if (gender.equalsIgnoreCase("mrs")){
            driver.findElement(mrsBtn).click();
        }
        else{
            System.out.println("invalid gender input");
        }
    }

    public void insertFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void insertLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void insertPasswrod(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    //Select Date of Birth
    public void selectDateofBirth(String day, String month, String year){
        drpDay = new Select(driver.findElement(daysDropDownList));
        drpMonth = new Select(driver.findElement(monthsDropDownList));
        drpYear = new Select(driver.findElement(yearsDropDownList));

        drpDay.selectByValue(day);
        drpMonth.selectByValue(month);
        drpYear.selectByValue(year);
    }

    //Insert Address
    public void insertAddress(String address){
        driver.findElement(address1Field).sendKeys(address);
    }

    //Insert City
    public void insertCity(String city){
        driver.findElement(cityField).sendKeys(city);
    }

    //Select State
    public void selectState(String state){
        drpState = new Select(driver.findElement(stateDropDownList));
        drpState.selectByVisibleText(state);
    }

    //Insert Postal Code
    public void insertPostalCode(String postalCode){
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    //Select Country
    public void selectCountry(String country){
        drpCountry = new Select(driver.findElement(countryDropDownList));
        drpCountry.selectByVisibleText(country);
    }

    //Insert Mobile Number
    public void insertMobNumber(String mobNum){
        driver.findElement(mobField).sendKeys(mobNum);
    }

    //Insert Alias Address
    public void insertAliasAddress(String aliasAddress){
        driver.findElement(addressAlias).sendKeys(aliasAddress);
    }

    //Click on Submit
    public MyAccountPage clickSubmit(){

        driver.findElement(submitBtn).click();
        return new MyAccountPage(driver);
    }

    //Fill data to Sign up
    public void fillSignUpForm(String Title, String firstName, String lastName, String password, String day, String month, String year,
                               String address, String city, String state, String postalCode, String country, String mobNum, String aliasAddress){
        selectGender(Title);
        insertFirstName(firstName);
        insertLastName(lastName);
        insertPasswrod(password);
        selectDateofBirth(day, month, year);
        insertAddress(address);
        insertCity(city);
        selectState(state);
        insertPostalCode(postalCode);
        selectCountry(country);
        insertMobNumber(mobNum);
        insertAliasAddress(aliasAddress);
    }

}
