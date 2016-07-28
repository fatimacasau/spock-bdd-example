package example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification

@WebAppConfiguration
@ContextConfiguration(loader = SpringApplicationContextLoader.class,classes = [Application.class])
@IntegrationTest("server.port:0")
class Example2_BlocksSpec extends Specification {

    @Autowired
    CustomerRepository customerRepository

    // Blocks & Specification as Documentation

    // Given - When - Then

    def "Import customers from file"(){
        given: 'A file with customers data'
            def file = new File('src/test/resources/friends.csv')
        when: 'read the file'
            def customers = file.readLines().collect {
                def values = it.split(',')
                new Customer(name: values[0], lastName: values[1])
            }
        and: 'saved into database'
            def customersSaved = customerRepository.save(customers)
        then: 'the customers exists'
            def textFile = file.text
            customersSaved.each {customer ->
                customer.name in textFile
            }
        and: 'the number of customers created is the same as the file lines'
            customersSaved.size() == textFile.readLines().size()

    }

    // Power asserts

    // Given - Expect

    @Ignore
    def "customer name not expected"(){
        given:'an existing customer'
            def customer = new Customer(name:"Pepito", lastName: "Perez")
        expect: 'the myName is not expected'
            customer.name == "Patricia" // This fails
    }
}
