package com.devadmkok.account.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
data class Customer(
        @Id
        @GeneratedValue(generator ="UUID") // //tahmin edilemeyen idler olsun. hashcode uretir bu biizm uuid olur. 32  harf rakamdan olusur
        @GenericGenerator(name= "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String?,

        val name: String?,
        val surname: String?,

        @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
        val accounts: Set<Transaction>?

)
