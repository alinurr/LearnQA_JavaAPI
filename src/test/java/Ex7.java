import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

public class Ex7 {

    @Test
    public void testLongRedirect(){

        //String locationHeader = response.getHeader("Location");

            Response response = RestAssured
                    .given()
                    .redirects()
                    .follow(true)
                    .when()
                    .get("https://playground.learnqa.ru/api/long_redirect")
                    .andReturn();
            int statusCode = response.getStatusCode();
            int count = 0;
            if (statusCode == 200){
                String locationHeader = response.getHeader("Location");
                count++;
                System.out.println(locationHeader + " " +count);
            }

    }


}
