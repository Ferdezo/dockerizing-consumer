package pl.ferdezo.dockerizingconsumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagementController {

    @GetMapping("/fail")
    public String fail() {
        System.exit(1);
        return "failed";
    }
}
