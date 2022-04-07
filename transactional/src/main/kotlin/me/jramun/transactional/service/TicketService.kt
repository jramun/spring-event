package me.jramun.transactional.service

import me.jramun.transactional.domain.Ticket
import me.jramun.transactional.repository.TicketRepo
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

class TicketService {}


@Component
class TicketListener(val ticketRepo: TicketRepo) {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    fun onFailedOrder(event: FailedOrderEvent) {
        println("Function TicketListener.onFailedOrder event [$event]")
        val ticket = Ticket()
        ticket.extra = "Ticket for onFailedOrder order [${event.orders.id}]"
        this.ticketRepo.save(ticket)
    }

}