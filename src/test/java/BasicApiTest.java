import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class BasicApiTest extends BaseTest {

    @Test
    public void T01_StatusCodeAndGetClientsTest() {
        res = utils.RestAssuredUtil.getResponse("/gen/clients");
        testUtil.checkStatusIs200(res);
        jp = utils.RestAssuredUtil.getJsonPath(res);
        System.out.println(testUtil.getClients(jp));
    }

    @Test
    public void T02_GetAndroidModelPackageOptions() {
        res = utils.RestAssuredUtil.getResponse("/gen/clients/android");
        testUtil.checkStatusIs200(res);
        jp = utils.RestAssuredUtil.getJsonPath(res);
        System.out.println("Opt: " + jp.get("modelPackage.opt"));
        System.out.println("Description: " + jp.get("modelPackage.description"));
        System.out.println("Type: " + jp.get("modelPackage.type"));
    }

    @Test
    public void T03_GetAdaModelPackageOptions() {
        res = utils.RestAssuredUtil.getResponse("/gen/clients/ada");
        testUtil.checkStatusIs200(res);
        jp = utils.RestAssuredUtil.getJsonPath(res);
        System.out.println("Opt: " + jp.get("modelPackage.opt"));
        System.out.println("Description: " + jp.get("modelPackage.description"));
        System.out.println("Type: " + jp.get("modelPackage.type"));
    }

    @Test
    public void T04_PostAdaModelPackageOptions() {
        String postData = "{\n  \"name\": \"morpheus\",\n  \"job\": \"leader\"\n}";
        given().
                contentType(ContentType.JSON).
                body(postData).
                when().
                post("https://reqres.in/api/users").
                then().
                statusCode(201).
                body("name", equalTo("morpheus"));
    }


}
