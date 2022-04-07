package me.jramun.transactional.service

import me.jramun.transactional.repository.PromotionRepo
import me.jramun.transactional.domain.Promotion
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

class PromotionService {}


@Component
class PromotionListener(val promotionRepo: PromotionRepo) {


    @EventListener
    fun onRegister(event: RegisterEvent) {
        println("Function PromotionListener.onRegister event [$event]")
        val promotion = Promotion()
        promotion.extra = "New customer is registered username [${event.customer.username}]"
        this.promotionRepo.save(promotion)
    }


    @EventListener
//    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    fun onCompletedOrder(event: CompletedOrderEvent) {
        println("Function PromotionListener.onCompletedOrder event [$event]")
        val promotion = Promotion()
        promotion.extra = "Order is completed order [${event.orders.id}]"
        this.promotionRepo.save(promotion)
    }

}