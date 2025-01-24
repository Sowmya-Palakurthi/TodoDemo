package com.example
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date
import org.jetbrains.exposed.sql.javatime.datetime

object users : Table("users") {
    val emailid = varchar("emailid", length = 255).uniqueIndex()
    val username = varchar("username", length = 100)
    val password = varchar("password", length = 255)
    override val primaryKey = PrimaryKey(emailid)
}

object tasks : Table("tasks") {
    val title = varchar("title", length = 200)
    val description = text("description")
    val isdone = bool("isdone").default(false)
    val emailid = varchar("emailid", length = 255).references(users.emailid, onDelete = ReferenceOption.CASCADE)
    val deadline = varchar("deadline",length=255)// Nullable field to store deadline


    override val primaryKey = PrimaryKey(title, emailid)
}
