package example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository

    @ResponseStatus(HttpStatus.OK)
    public Customer findByName(@PathVariable String name) {
        customerRepository.findByName(name)
    }

}

