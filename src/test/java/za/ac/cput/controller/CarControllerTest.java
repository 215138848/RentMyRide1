package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Car;
import za.ac.cput.factory.CarFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarControllerTest {

    private static Car car = CarFactory.createCar(
            "412556",
            "Blue",
            "Ford",
            "Mustang",
            9500.00,
            "Storage Unit 6",
            true
    );
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/car";

    @Test
    void a_create()
    {
        String url = baseURL + "/create";
        ResponseEntity<Car> postResponse = restTemplate.postForEntity(url, car , Car.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        car = postResponse.getBody();
        System.out.println("Saved data: " + car);
        assertEquals(car.getNumberPlate(), postResponse.getBody().getNumberPlate());
    }

    @Test
    void b_read()
    {
        String url = baseURL + "/read/" + car.getNumberPlate();
        System.out.println("URL: " + url);
        ResponseEntity<Car> response = restTemplate.getForEntity(url, Car.class);
        assertEquals(car.getNumberPlate(), response.getBody().getNumberPlate());
    }

    @Test
    void c_update()
    {
        Car updated = new Car.Builder().copy(car).color("Yellow").build();
        String url = baseURL + "/update";
        System.out.println("Post data: " + updated);
        ResponseEntity<Car> response = restTemplate.postForEntity(url, updated, Car.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete()
    {
        String url = baseURL + "/delete/" + car.getNumberPlate();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll()
    {
        String url = baseURL + "/getall/";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

}