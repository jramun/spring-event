package me.jramun.basic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class BasicApp {


    @Autowired
    lateinit var customerService: CustomerService

    @Autowired
    lateinit var orderService: OrderService

    @Bean
    fun runner(): ApplicationRunner {
        return ApplicationRunner {
            this.scenarioRegister()
            this.scenarioNewOrder()
        }
    }

    fun scenarioRegister() {
        this.customerService.register("user")
        println("----------------------------------")
    }

    fun scenarioNewOrder() {
        this.orderService.newOrder("user")
        println("----------------------------------")
    }
}


fun main(args: Array<String>) {
    runApplication<BasicApp>(*args)

}
