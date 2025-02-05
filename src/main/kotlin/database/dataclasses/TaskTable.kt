package com.example.database.dataclasses

import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

object tasks : Table("tasks") {


    val title = varchar("title", length = 200)
    val description = text("description")
    val isdone = bool("isdone").default(false)
    val emailid = varchar("emailid", length = 255).references(users.emailid, onDelete = ReferenceOption.CASCADE)
    val deadline = varchar("deadline",length=255)
    override val primaryKey = PrimaryKey(title, emailid)
}

