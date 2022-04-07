package me.jramun.basic

import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import kotlin.random.Random

data class Wallet(var username: String, var balance: Long) {}

@Service
class WalletService {

    fun update(username: String, balance: Long) {
        println("WalletService update is called username [$username] balance [$balance]")
    }

}

@Component
class WalletListeners(var walletService: WalletService) {

    /**
     * Condition
     * true
     * event
     * bean
     * ...
     */
    @EventListener()
    fun onNewOrder(event: NewOrderEvent) {
        println("WalletListeners onNewOrder is called event [$event]")
        this.walletService.update(event.order.username, Random(1000).nextLong())
    }
}