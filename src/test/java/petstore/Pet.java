package petstore;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class Pet {
    String url = "https://petstore.swagger.io/v2/pet";

    public String lerJson(String pathJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(pathJson)));
    }

    @Test // Identifica o método ou função para o TestNG
    public void includePath() throws IOException {
        String jsonBody = lerJson("db/pet1.json");

        //Sintaxe Gherkin
        // Dado - Quando - Então
        // given, when, then
        given()
                .contentType("application/json")// comum em API REST - antigas era "text/xml"
                .log().all()
                .body(jsonBody)
        .when()
                .post(url)
        .then()
                .log().all()
                .statusCode(200)
        ;
    }
}
