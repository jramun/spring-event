package me.jramun.transactional.service

import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component


@Component
class EmailListeners {


    @EventListener
    fun onRegister(event: RegisterEvent) {
        println("Function EmailListeners.onRegister event [$event]")
    }

    @Async
    @EventListener
    fun onCompletedOrder(event: CompletedOrderEvent) {
        println("Function EmailListeners.onCompletedOrder event [$event]")
    }
}