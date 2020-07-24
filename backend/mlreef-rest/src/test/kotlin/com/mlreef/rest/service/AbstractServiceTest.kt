package com.mlreef.rest.service

import com.mlreef.rest.ApplicationConfiguration
import com.mlreef.rest.ApplicationProfiles
import com.mlreef.rest.EpfConfiguration
import com.mlreef.rest.GitlabConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import javax.persistence.EntityManager
import javax.sql.DataSource

@TestPropertySource(properties = [
    "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect"
])
@EnableConfigurationProperties(
    ApplicationConfiguration::class,
    GitlabConfiguration::class,
    EpfConfiguration::class
)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@DataJpaTest(showSql = false)
@ActiveProfiles(ApplicationProfiles.TEST)
abstract class AbstractServiceTest {

    @Autowired
    lateinit var config: ApplicationConfiguration

    @Autowired
    private val dataSource: DataSource? = null

    @Autowired
    private val jdbcTemplate: JdbcTemplate? = null

    @Autowired
    private val entityManager: EntityManager? = null

}