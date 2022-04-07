package me.jramun.transactional

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class TransactionalApp


fun main(args: Array<String>) {
    runApplication<TransactionalApp>(*args)

}
