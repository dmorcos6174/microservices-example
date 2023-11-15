package apigateway.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api")
public class ApigatewayController {

    private final RestTemplate restTemplate;

    private final WebClient.Builder webClientBuilder;

    public ApigatewayController(RestTemplate restTemplate, WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplate;
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping("/sayHello")
    public String getSayHello() {
        return restTemplate.getForObject("http://helloworld/sayHello", String.class);
//        return webClientBuilder.build()
//                .get()
//                .uri("http://helloworld/sayHello")
//                .retrieve()
//                .bodyToMono(String.class);
    }
}
