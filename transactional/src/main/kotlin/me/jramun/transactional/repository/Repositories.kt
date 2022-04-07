package me.jramun.transactional.repository

import me.jramun.transactional.domain.Customer
import me.jramun.transactional.domain.Orders
import me.jramun.transactional.domain.Promotion
import me.jramun.transactional.domain.Ticket
import org.springframework.data.jpa.repository.JpaRepository


interface PromotionRepo : JpaRepository<Promotion, Long>
interface OrderRepo : JpaRepository<Orders, Long>
interface CustomerRepo : JpaRepository<Customer, Long>
interface TicketRepo : JpaRepository<Ticket, Long>