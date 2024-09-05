package net.projecttl.springboot.template.config

import org.jetbrains.exposed.sql.Database
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class DatabaseConfig(private val dataSource: DataSource) {
    @Bean
    fun database() = Database.connect(dataSource)
}