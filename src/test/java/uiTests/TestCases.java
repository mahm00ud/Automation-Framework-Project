package uiTests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCases extends TestBase {

    @Test(priority = 1)
    public void validateSuccessfullSignup(){
        homePage.clickOnSignInBtn();
        signinPage.insertEmail(dataReader.getExcelValueByAttribute("CreateAccount Data", "Email"));
        signinPage.clickOnCreateAccountBtn();

        createAccountPage.fillSignUpForm(dataReader.getExcelValueByAttribute("CreateAccount Data", "Title"),
                dataReader.getExcelValueByAttribute("CreateAccount Data","FirstName"),
                dataReader.getExcelValueByAttribute("CreateAccount Data","LastName"),
                dataReader.getExcelValueByAttribute("CreateAccount Data","Password"),
                dataReader.getExcelValueByAttribute("CreateAccount Data","Day"),
                dataReader.getExcelValueByAttribute("CreateAccount Data","Month"),
                dataReader.getExcelValueByAttribute("CreateAccount Data","Year"),
                dataReader.getExcelValueByAttribute("CreateAccount Data","Address"),
                dataReader.getExcelValueByAttribute("CreateAccount Data","City"),
                dataReader.getExcelValueByAttribute("CreateAccount Data","State"),
                dataReader.getExcelValueByAttribute("CreateAccount Data","PostalCode"),
                dataReader.getExcelValueByAttribute("CreateAccount Data","Country"),
                dataReader.getExcelValueByAttribute("CreateAccount Data","MobilePhone"),
                dataReader.getExcelValueByAttribute("CreateAccount Data","AddressAlias"));

        createAccountPage.clickSubmit();

        Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",
                myAccountPage.getWelcomeMsg());
    }

    @Test(priority = 2)
    public void validateSuccessfullLogin(){
        homePage.clickOnSignInBtn();
        signinPage.login(dataReader.getExcelValueByAttribute("CreateAccount Data", "Email"),
                dataReader.getExcelValueByAttribute("CreateAccount Data", "Password"));

        Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",
                myAccountPage.getWelcomeMsg());
    }

    @Test(priority = 3)
    public void validateProductIsAddedToCartSuccessfully(){

        driver.navigate().to(dataReader.getExcelValueByAttribute("URLs", "BlousesPage"));
        productPage.hoverOverBlouse();
        productPage.addProductToCart();

        Assert.assertTrue(productPage.getAddToCartMsg().contains("successfully added to your shopping cart"));;
    }

    @Test(priority = 4)
    public void validateMakingOrderSuccesfully(){
        homePage.clickOnSignInBtn();
        signinPage.login(dataReader.getExcelValueByAttribute("CreateAccount Data", "Email"),
                dataReader.getExcelValueByAttribute("CreateAccount Data", "Password"));

        homePage.hoverOverWomen();
        homePage.clickOnBlouses();
        productPage.hoverOverBlouse();
        productPage.addProductToCart();
        productPage.clickOnCheckout();
        cartSummaryPage.clickOnProceedToCheckout1();
        cartAddressPage.clickOnProceedToCheckout3();
        cartShippingPage.agreeOnTerms();
        cartShippingPage.clickOnProceedToCheckout4();
        cartPaymentPage.clickOnBankWire();
        orderSummaryPage.clickOnConfirmOrder();

        Assert.assertEquals("Your order on My Store is complete.",
                confirmationPage.getConfirmationText());
    }

    @Test(priority = 5)
    public void validateOrderIsDisplayedInOrderHistoryPageAferOrderIsMade(){
        homePage.clickOnSignInBtn();
        signinPage.login(dataReader.getExcelValueByAttribute("CreateAccount Data", "Email"),
                dataReader.getExcelValueByAttribute("CreateAccount Data", "Password"));

        homePage.hoverOverWomen();
        homePage.clickOnBlouses();
        productPage.hoverOverBlouse();
        productPage.addProductToCart();
        productPage.clickOnCheckout();
        cartSummaryPage.clickOnProceedToCheckout1();
        cartAddressPage.clickOnProceedToCheckout3();
        cartShippingPage.agreeOnTerms();
        cartShippingPage.clickOnProceedToCheckout4();
        cartPaymentPage.clickOnBankWire();
        orderSummaryPage.clickOnConfirmOrder();

        String orderID = confirmationPage.getOrderID();

        homePage.clickOnCustomerName();

        myAccountPage.clickOnOrderHistory();

        Assert.assertTrue(orderHistoryPage.getLastOrderID().contains(orderID));

    }

}
