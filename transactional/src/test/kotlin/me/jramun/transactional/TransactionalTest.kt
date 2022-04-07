package me.jramun.transactional

import me.jramun.transactional.domain.Orders
import me.jramun.transactional.repository.CustomerRepo
import me.jramun.transactional.repository.OrderRepo
import me.jramun.transactional.service.CustomerService
import me.jramun.transactional.service.OrderService
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import javax.transaction.Transactional
import kotlin.random.Random


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class TransactionalTest {

    @Autowired
    lateinit var customerService: CustomerService

    @Autowired
    lateinit var customerRepo: CustomerRepo

    @Autowired
    lateinit var orderService: OrderService

    @Autowired
    lateinit var orderRepo: OrderRepo

    @Test
    fun scenario_register() {
        this.customerService.register("new-user")
    }

    @Test
    fun scenario_new_order() {
        val order = Orders()
        val customer = this.customerRepo.findAll()[0]
        order.extra = "New order for customer ${customer.username}"
        order.referral = Random(100).toString()
        order.customer = customer
        this.orderService.newOrder(order)
        this.orderService.completedOrder(order)
    }
}
