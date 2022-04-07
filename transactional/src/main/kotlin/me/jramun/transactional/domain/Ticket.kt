package me.jramun.transactional.domain

import javax.persistence.*


@Entity
@Table
class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @Basic
    @Column
    var extra: String? = null
}