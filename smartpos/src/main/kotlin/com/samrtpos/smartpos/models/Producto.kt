package com.samrtpos.smartpos.models
import jakarta.persistence.*

@Entity
@Table(name = "productos")
data class Producto(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(nullable = false)
        val name: String,

        @Column(nullable = false)
        val category: String,

        @Column(nullable = false)
        val price: Double,

        @Column(nullable = false)
        val quantity: Int
)
