import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Add;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicAPI {
	
	@Test(dataProvider="addBooksData")
	public void post() {
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().header("content-Type","application/json")
		.body(Add.AddBook("qwer","123"))
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		JsonPath jp = new JsonPath(response);
		String id=jp.get("ID");
		
		
	}

	@DataProvider(name="addBooksData")
	public Object[][] getData() {
		 return new Object[][] { {"wewr","1231"},{"ds","2324"},{"asd","564"}  };
	}
}
