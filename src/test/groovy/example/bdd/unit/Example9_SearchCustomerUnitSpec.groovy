package example.bdd.unit

import example.CustomerController
import example.CustomerRepository
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject

@Narrative("""
As a user
I want to search customers by name
to find them quickly
""")
class Example9_SearchCustomerUnitSpec extends Specification{

    // Mocking services
    def customerRepository = Mock(CustomerRepository)

    // Init controller with mock:
    def @Subject controller = new CustomerController(customerRepository: customerRepository)

    // Let Spring MVC Test process the controller:
    def mockMvc = MockMvcBuilders.standaloneSetup(controller).build()


    def 'Search customer -> Scenario #1: Happy Path'() {
        given: "The name of an existing customer"
            // Set value to a 'name' variable
            /* __complete__*/
        when: "search for the customer by that name"
            // Try different URL or Method to see what will happen!
            /* def resultRestCall = mockMvc.perform(get("__complete__")) */
        then: "the result is successfully"
            // Expect 1 call to repository to get users:
            /*  __complete__ */

            // Expect http status == 200 && contentType == APPLICATION_JSON
            /* resultRestCall.andExpect(status().isOk())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON)) */
    }
}
