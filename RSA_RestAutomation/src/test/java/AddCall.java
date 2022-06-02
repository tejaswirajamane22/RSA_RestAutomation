import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Add;



public class AddCall {

	public static void main(String[] args) {

		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Add.addBody())
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
	
	System.out.println(response);
	
	JsonPath jp = new JsonPath(response);
	String placeid=jp.get("place_id");
	
	System.out.println(placeid);
	
	//update call- put call
	
	String newAddress ="70 Summer walk, Africa";
	
	given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	.body("{\r\n"
			+ "\"place_id\":\""+placeid+"\",\r\n"
			+ "\"address\":\""+newAddress+"\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}")
	.when().put("/maps/api/place/update/json")
	.then().assertThat().statusCode(200).body("msg", equalTo("Address succesfully updated"));
	
	//get call
	String GetResponse=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
	.when().get("/maps/api/place/get/json")
	.then()
	.assertThat().statusCode(200).extract().response().asString();
	JsonPath jp1 = new JsonPath(response);
	String acutalAddress=jp1.get("address");
	
	}
	

}
