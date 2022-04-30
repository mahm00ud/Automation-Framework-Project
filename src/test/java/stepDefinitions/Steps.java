package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Steps {

    private static final String BASE_URL = "http://www.colourlovers.com/";
    private static Response response;
    private static Response responseBody;
    private static XmlPath xmplPath;
    private static List<String> stringnumViewsList;
    private static List<Integer> intnumViewsList;

    @Given("I send a request to get all Patterns")
    public void SendRequest(){
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get("api/patterns");
        request.header("User-Agent", "PostmanRuntime/7.29.0");
        response = request.get("api/patterns");
    }

    @Then("I should Receive a response body of patterns")
    public void getResponseBody(){
        responseBody =response.then().extract().response();
        xmplPath = response.xmlPath();

        stringnumViewsList = xmplPath.getList("patterns.pattern.numViews");
        intnumViewsList =   stringnumViewsList.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
    @And("Number of views Should be greater than 4000")
    public void assertNumViewGreaterThan4000(){
        System.out.println(intnumViewsList);
        Assert.assertTrue("Not all numViews are greater than 4000" ,intnumViewsList.stream().allMatch(i -> i>4000));
    }
}
