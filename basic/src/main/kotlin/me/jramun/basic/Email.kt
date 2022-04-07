package me.jramun.basic

import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class EmailService {

    fun send(email: String) {
        Thread.sleep(2000)
        println("EmailService send is called email [$email]")
    }
}

@Component
class EmailListeners(var emailService: EmailService) {


    //    Sync
    @EventListener
    fun onRegistered(event: CustomerRegisteredEvent) {
        println("EmailListeners onRegistered is called event [$event]")
        emailService.send(event.customer.username)
    }


    @Async
    @EventListener
    fun onNewOrder(event: NewOrderEvent) {
        println("EmailListeners onNewOrder is called event [$event]")
        emailService.send(event.order.username)
    }

}