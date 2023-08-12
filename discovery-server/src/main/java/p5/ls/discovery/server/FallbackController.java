package p5.ls.discovery.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/orderServiceFallBack")
    public Mono<String> orderServiceFallBack() {
        return Mono.just("Order Service is taking too long to respond or is down. Please try again later");
    }

    @RequestMapping("/paymentServiceFallback")
    public Mono<String> paymentServiceFallBack() {
        return Mono.just("Payment Service is taking too long to respond or is down. Please try again later");
    }

}

