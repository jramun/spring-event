package me.jramun.basic

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import kotlin.random.Random

data class Order(var username: String, var orderId: Long, var extera: String) {}

data class NewOrderEvent(var order: Order) {}

@Service
class OrderService(var publisher: ApplicationEventPublisher) {

    fun newOrder(username: String) {
        val order = Order(username, Random(1000).nextLong(), "I am a new order!")
        println("OrderService newOrder is called order [$order]")
        this.publisher.publishEvent(NewOrderEvent(order))
    }
}