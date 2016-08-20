package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.restapi.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Administrator;
import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.restapi.RestAPI;

/**
 * Created by Bonga on 8/20/2016.
 */
public class AdministratorRest implements RestAPI<Administrator, Long> {

    final String BASE_URL = "http://localhoast:8080/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    public Administrator get(Long id) {

        final String url = BASE_URL + "admin/" + id.toString();

        HttpEntity<Administrator> requestEntity = new HttpEntity<>(requestHeaders);
        ResponseEntity<Administrator> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Administrator.class);

        Administrator admin = responseEntity.getBody();

        return admin;
    }

    @Override
    public String post(Administrator entity) {
        return null;
    }

    @Override
    public String put(Administrator entity) {
        return null;
    }

    @Override
    public String delete(Administrator entity) {
        return null;
    }

    @Override
    public List<Administrator> getAll() {
        return null;
    }
}