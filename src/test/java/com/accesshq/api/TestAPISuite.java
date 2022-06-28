package com.accesshq.api;

import io.restassured.path.json.JsonPath;
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestAPISuite {
    @Test
    public void verify_search_API(){
        given().
                header("auth-key","46ffb65d-f7af-4dd5-93e8-6fbcc5869d9f").
                param("q","TASCOTT").
                param("state","NSW").
        when().
        get("https://digitalapi.auspost.com.au/postcode/search.json").
                then().assertThat().statusCode(200);

    }
    @Test
    public void check_postCode_API(){

        given().
                header("auth-key","46ffb65d-f7af-4dd5-93e8-6fbcc5869d9f").
                param("q","TASCOTT").
                param("state","NSW").
        when().
                get("https://digitalapi.auspost.com.au/postcode/search.json").
         then().assertThat().body("localities.locality.postcode",equalTo(4500));

    }

}
