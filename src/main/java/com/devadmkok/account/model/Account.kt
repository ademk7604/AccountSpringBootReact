package com.devadmkok.account.model

import jakarta.persistence.*
import org.hibernate.Hibernate
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
        @JoinColumn(name = :"customer_id" {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as Account

                return id != null && id == other.id
        }

        override fun hashCode(): Int = javaClass.hashCode()
}, nullable = false)
        val customer: Customer?,

        @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
        val transaction: Set<Transaction>?

        )
{


}

