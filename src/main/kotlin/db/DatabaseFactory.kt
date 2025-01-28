package com.example.db

import com.example.tasks
import com.example.users
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {   //used to initialize databases and setup tables
    fun init() {  //used for initialization

        val config = HikariConfig().apply {
            jdbcUrl = "jdbc:postgresql://localhost:5432/todoapp"
            driverClassName = "org.postgresql.Driver"
            username = "postgres"
            password = "admin"
            maximumPoolSize = 10
        }

        val dataSource = HikariDataSource(config) //entry point for db connections
        Database.connect(dataSource)
        transaction {
            SchemaUtils.create(users, tasks) //create the tables in db if they don't already exist
        }
    }
}

suspend fun <T> dbQuery(block: suspend () -> T): T =
    newSuspendedTransaction(Dispatchers.IO) { block() }