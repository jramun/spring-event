package me.jramun.transactional.service

import me.jramun.transactional.repository.CustomerRepo
import me.jramun.transactional.domain.Customer
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service


@Service
class CustomerService(var publisher: ApplicationEventPublisher, var customerRepo: CustomerRepo) {

    fun register(username: String) {
        val customer = Customer()
        customer.username = username
        this.customerRepo.save(customer)
        this.publisher.publishEvent(RegisterEvent(customer))
    }
}


data class RegisterEvent(var customer: Customer) {}

