package com.devadmkok.account.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime


@Entity
data class Account(
        @Id
        @GeneratedValue(generator ="UUID") // //tahmin edilemeyen idler olsun. hashcode uretir bu biizm uuid olur. 32  harf rakamdan olusur
        @GenericGenerator(name= "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String?,
        val balance: BigDecimal? = BigDecimal.ZERO,
        val creationDate: LocalDateTime,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name = :"customer_id", nullable = false)
        val customer: Customer?,

        @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
        val transaction: Set<Transaction>?

        )
{

}

