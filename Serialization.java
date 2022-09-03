package org.GoogleAPI;

import java.util.ArrayList;
import java.util.List;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Serialization {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		MapResponse m = new MapResponse();
		m.setAccuracy(50);
		m.setName("Frontline house");
		m.setPhone_number("(+91) 983 893 3937");
		m.setAddress("29, side layout, cohen 09");
		m.setWebsite("http://google.com");
		m.setLanguage("French-IN");
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		m.setLocation(l);
		
		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		m.setTypes(types);
		
		Response as= given().log().all().headers("Content-Type","application/json")
		.queryParam("key","qaclick123").body(m)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().as(Response.class);
		
		System.out.println(as.getStatus());
		System.out.println(as.getPlace_id());
		System.out.println(as.getScope());
		System.out.println(as.getReference());
		System.out.println(as.getId());
	}

}
