package me.jramun.transactional.domain

import javax.persistence.*

@Table
@Entity
class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @Basic
    @Column
    var extra: String? = null
}