package me.jramun.transactional.domain

import javax.persistence.*

@Entity
@Table
class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @Basic
    @Column
    var username: String? = null


    @Column(nullable = false)
    var firstName: String = ""

}