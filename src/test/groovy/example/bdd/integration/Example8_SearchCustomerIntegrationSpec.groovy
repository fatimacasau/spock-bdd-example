package example.bdd.integration

import example.Application
import example.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Narrative
import spock.lang.Specification

@Narrative("""
As a user
I want to search customers by name
to find them quickly
""")
@WebAppConfiguration
@ContextConfiguration(loader = SpringApplicationContextLoader.class,classes = [Application.class])
@IntegrationTest("server.port:0")
class Example8_SearchCustomerIntegrationSpec extends Specification{

    @Value("\${local.server.port}")
    int port;

    @Value("\${server.context-path}")
    String contextPath

    @Autowired
    CustomerRepository customerRepository

    def "Search customer -> Scenario #1: Happy Path"(){
        given: "The name of an existing customer"
            // Set value to a 'name' variable
            /* __complete__*/
        when: "search for the customer by that name"
            // Try different URL or Method to see what will happen
            /* __complete__*/
        then: "the result is successfully"
            // Expect http status == 200
            /* __complete__*/
    }

}
