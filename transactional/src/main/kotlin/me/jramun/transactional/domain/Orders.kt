package me.jramun.transactional.domain

import javax.persistence.*

@Entity
@Table
class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    var customer: Customer? = null

    @Column
    @Enumerated(EnumType.STRING)
    var status: OrderStatus = OrderStatus.PROGRESS

    @Basic
    @Column(nullable = true)
    var referral: String? = null

    @Basic
    @Column(nullable = true)
    var extra: String? = null
}

enum class OrderStatus {
    COMPLETED, PROGRESS, FAILED
}