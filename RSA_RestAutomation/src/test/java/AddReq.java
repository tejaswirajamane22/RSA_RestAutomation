import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AddReq {
	
public static void main(String[] args) {
	
	
	RestAssured.baseURI="https://reqres.in";
	given().log().all().header("Content-Type", "application/json" )
	.body("{\r\n"
			+ "    \"data\": {\r\n"
			+ "        \"id\": 2,\r\n"
			+ "        \"email\": \"janet.weaver@reqres.in\",\r\n"
			+ "        \"first_name\": \"Janet\",\r\n"
			+ "        \"last_name\": \"Weaver\",\r\n"
			+ "        \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\r\n"
			+ "    },\r\n"
			+ "    \"support\": {\r\n"
			+ "        \"url\": \"https://reqres.in/#support-heading\",\r\n"
			+ "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\r\n"
			+ "    }\r\n"
			+ "}")
	.post()
	.then()
	.assertThat()
	.statusCode(200);

}
}
