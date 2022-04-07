package me.jramun.basic

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

data class Customer(var username: String) {}

data class CustomerRegisteredEvent(var customer: Customer) {

}

@Service
class CustomerService(var publisher: ApplicationEventPublisher) {

    fun register(username: String) {
        val customer = Customer(username)
        println("CustomerService register is called username [$customer]")
        this.publisher.publishEvent(CustomerRegisteredEvent(customer))
    }
}

