package com.guru.gurukotlin.domain

import jakarta.persistence.*

@Entity
@Table(name = "authors")
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,
    var firstName: String,
    var lastName: String,

    @ManyToMany(mappedBy = "authors")
    var books: Set<Book> = HashSet()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Author) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Author(id=$id, firstName='$firstName', lastName='$lastName', books=$books)"
    }
}