package com.guru.gurukotlin.domain

import jakarta.persistence.*

@Entity
@Table(name = "publisher")
data class Publisher(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,
    val publisherName: String,
    val address: String,
    val city: String?,
    val state: String?,
    val zipCod: String?,

    @OneToMany(mappedBy = "publisher")
    var books: Set<Book> = HashSet()
) {


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Publisher) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Publisher(id=$id, publisherName='$publisherName', address='$address', city=$city, state=$state, zipCod=$zipCod, books=$books)"
    }
}


