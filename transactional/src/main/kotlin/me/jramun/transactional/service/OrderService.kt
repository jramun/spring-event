package me.jramun.transactional.service

import me.jramun.transactional.repository.OrderRepo
import me.jramun.transactional.domain.Orders
import me.jramun.transactional.domain.OrderStatus
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class OrderService(var publisher: ApplicationEventPublisher, var orderRepo: OrderRepo) {

    fun newOrder(orders: Orders) {
        this.orderRepo.save(orders)
        println("Function OrderService.newOrder order [$orders]")
    }

    fun completedOrder(orders: Orders) {
        orders.status = OrderStatus.COMPLETED
        this.orderRepo.save(orders)
        println("Function OrderService.completedOrder order [$orders]")
        this.publisher.publishEvent(CompletedOrderEvent(orders))
    }
}


data class CompletedOrderEvent(var orders: Orders) {}
data class FailedOrderEvent(var orders: Orders) {}