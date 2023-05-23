package com.devadmkok.account.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Transaction(
        @Id
        @GeneratedValue(generator ="UUID") // //tahmin edilemeyen idler olsun. hashcode uretir bu biizm uuid olur. 32  harf rakamdan olusur
        @GenericGenerator(name= "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String?,
        val transactionType: TransactionType? = TransactionType.INITIAL,
        val amount: BigDecimal?,
        val transactionDate: LocalDateTime?,

        @ManytoOne(Fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
        @JoinColumn(name = "account_id", nullable = false)
        val account: Account
){

}


enum class TransactionType {
        INITIAL, TRANSFER
}
