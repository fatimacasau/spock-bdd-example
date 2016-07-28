package example.bdd.integration

import example.Application
import example.CustomerRepository
import groovyx.net.http.RESTClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Narrative
import spock.lang.Specification
import static groovyx.net.http.ContentType.JSON

@Narrative("""
As a user
I want to create a new customer
to register it in data base
""")
@WebAppConfiguration
@ContextConfiguration(loader = SpringApplicationContextLoader.class,classes = [Application.class])
@IntegrationTest("server.port:0")
class Example7_CreateCustomerIntegrationSpec extends Specification{

    @Value("\${local.server.port}")
    int port;

    @Value("\${server.context-path}")
    String contextPath

    @Autowired
    CustomerRepository customerRepository

    // Example
    def "Create customer -> Scenario #1: Happy path"(){
        given: "customer data"
            def params = [name:"fatima", lastName:"casau"]
        when: "search a customer by that name"
            def customer = customerRepository.findByName(params.name)
        then: "the customer doesn't exist in database"
            !customer
        when: "create the new customer with the previous data"
            RESTClient rest = new RESTClient("http://localhost:$port")
            def uri = "$contextPath/customer"
            def response = rest.post(requestContentType : JSON, path : uri, body : params)
        then: "the result is successfully"
            response.status == HttpStatus.CREATED.value()
    }

    // Implement!
    def "Create customer -> Scenario #2: The customer exists previously"(){
        /* __complete__ */
    }

    // Implement DataDriven Test to create a customer
    // with different params using tag @Unroll
    /* __complete__*/

}
