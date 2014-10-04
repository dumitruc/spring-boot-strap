package com.dumitruc.training.ws;

import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.util.FileUtil;
import com.jayway.restassured.response.Response;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.jetty.ServletContextInitializerConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import static com.jayway.restassured.RestAssured.*;

/**
 * Created with IntelliJ IDEA.
 * User: dumitruc
 * Date: 03/10/14
 * Time: 23:34
 * To change this template use File | Settings | File Templates.
 */

import com.dumitruc.training.ws.Person;

import java.io.File;

@ContextConfiguration(locations = {"classpath*:cucumber.xml"})
public class StepDefHello {

    ApplicationContext springApplicationContext;

    //    @Autowired
    private Person dima = Person.getInstance();

    private final static String DEST_URL = "http://localhost:8080";

    @Given("^we have a valid XML template shiporder\\.xml$")
    public void we_have_a_valid_XML_template_shiporder_xml() throws Throwable {
        System.out.println("dima.getName() = " + dima.getName());
        System.out.println("dima.getSex() = " + dima.getSex());
        System.out.println("dima.getAge() = " + dima.getAge());
    }

    @Given("^is valid against the schema xsd file name$")
    public void is_valid_against_the_schema_xsd_file_name() throws Throwable {
        ClassLoader classLoader = getClass().getClassLoader();
        Response restResponse = given()
                .contentType("application/json")
                .body(FileUtils.readFileToString(new File(classLoader.getResource("dima-person.json").getFile())))
                .post(DEST_URL);
        restResponse.getBody().peek();
    }

    @When("^I set the order quantity to order quantity in the XML$")
    public void i_set_the_order_quantity_to_order_quantity_in_the_XML() throws Throwable {
        System.out.println("Here is new MAN:");
        System.out.println("Steps dima = " + dima);
        System.out.println("dima.getName() = " + dima.getName());
        System.out.println("dima.getSex() = " + dima.getSex());
        System.out.println("dima.getAge() = " + dima.getAge());
    }

    @Then("^the schema validation accepts the input as type$")
    public void the_schema_validation_accepts_the_input_as_type() throws Throwable {

        System.out.println("================Trying out the XML part");
        ClassLoader classLoader = getClass().getClassLoader();
        Response restResponse = given()
                .contentType("application/xhtml+xml")
                .body(FileUtils.readFileToString(new File(classLoader.getResource("dima-person.xml").getFile())))
                .post(DEST_URL);
        restResponse.getBody().peek();

    }

    @Before
    public void setup() {
        springApplicationContext = SpringApplication.run(SampleController.class);
    }


    @After
    public void tearDown() {
        SpringApplication.exit(springApplicationContext, new ExitCodeGenerator() {
            @Override
            public int getExitCode() {
                System.out.println("Execution complete, stopping the server");
                return 0;
            }
        });
    }
}
