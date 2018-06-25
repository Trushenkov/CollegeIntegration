package ru.itmech.collegeintegration;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import ru.itmech.collegeintegration.domain.Person;

/**
 * Класс для тестирования приложения.
 *
 * @author Трушенков Дмитрий Сергеевич
 */
@RunWith(SpringRunner.class)
@Component
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = CollegeIntegrationApplication.class)
public class CollegeintegrationApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Метод для тестирования запроса для поиска по ФИО
     */
    @Test
    public void fullNameController() {
        String plainCreds = "admin_contingent:admin_contingent";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);

        HttpEntity<String> request = new HttpEntity<>(headers);

        restTemplate.exchange("/findbyfio/Трушенков Дмитрий Сергеевич", HttpMethod.GET, request, Person.class);
    }

    /**
     * Метод для тестирования запроса для поиска по номеру СНИЛСА
     */
    @Test
    public void snilsController() {
        String plainCreds = "admin_contingent:admin_contingent";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);

        HttpEntity<String> request = new HttpEntity<>(headers);

        restTemplate.exchange("/findbysnils/17943837727", HttpMethod.GET, request, Person.class);
    }

}
