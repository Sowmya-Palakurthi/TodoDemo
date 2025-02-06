package com.example.database.dataclasses

import org.jetbrains.exposed.sql.Table

// FIXME: Maintain PK as UUID and refer this key in Other Tables
object users : Table("users") {
    val emailid = varchar("emailid", length = 255).uniqueIndex()
    val username = varchar("username", length = 100)
    val password = varchar("password", length = 255)
    override val primaryKey = PrimaryKey(emailid)
}
