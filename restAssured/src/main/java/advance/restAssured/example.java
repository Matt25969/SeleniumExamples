package advance.restAssured;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class example {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	@Given("^a film exists with the Title IT$")
	public void a_book_exists_with_isbn() {
		request = given().contentType(ContentType.JSON);
	}

	@When("^a user retrieves the film by title$")
	public void a_user_retrieves_the_book_by_isbn() {
		response = request.when().get("http://www.omdbapi.com/?apikey=cf6d6c63&t=IT&y=2017");
		
		 System.out.println("response: " + response.prettyPrint());
	}

	@Then("^the status code reads (\\d+)$")
	public void verify_status_code(int statusCode) {
		json = response.then().statusCode(200).body("Rated", equalTo("R"));
	}

}
