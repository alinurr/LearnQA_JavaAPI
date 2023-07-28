import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class Ex5 {

    @Test
    public void testJsonParse(){

        JsonPath response = RestAssured
                .given()
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();


        String text = response.get("messages[1].message");
        System.out.println(text);
    }
}
