package io.platformbuilders.customers.integration;

import com.intuit.karate.junit5.Karate;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@ActiveProfiles("test")
@AutoConfigureEmbeddedDatabase
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class CustomerIntegrationTest {
    @Karate.Test
    public Karate customerIntegrationTest() {
        return Karate.run("classpath:integration/customer-integration.feature");
    }
}
