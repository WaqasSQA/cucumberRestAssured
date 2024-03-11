package step.definations;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.net.URI;
import java.net.URISyntaxException;

public class myStep {

    private final String BASE_URL = "localhost";
    private Response response;
    private Scenario scenario;

    @Before
            public void before (Scenario scenario){
        this.scenario = scenario;

    }

    @Given("get call to {string}")
    public void getCallToURL(String url) throws URISyntaxException {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecification = RestAssured.given();
        response = requestSpecification.when().get(new URI(url));

    }

    @Then("get the {string}")
    public void getThe(String statusCode) {
        int expectedStatusCode = Integer.parseInt(statusCode);
        int actualResponse = response.then().extract().statusCode();
        Assert.assertEquals(expectedStatusCode, actualResponse);
    }
    @Then("get the author {string}")
    public void getTheAuthor(String arg0) {
        String author = response.then().extract().path("author");
        Assert.assertEquals(author, arg0);
    }
}
