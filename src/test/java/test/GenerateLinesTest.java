package test;

import java.io.StringWriter;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.datafaker.Faker;

public class GenerateLinesTest {

    private Logger log = LoggerFactory.getLogger(getClass());

    Faker faker = new Faker();

    @Test
    public void generateLines() {
        int numberOfLines = Integer.valueOf(System.getProperty("faker.count", "10"));
        for (int i = 0; i < numberOfLines; i++) {
            double r = Math.random();
            if (r < 0.2) {
                log.error(generatePhrase(10, 30));
            } else if (r < 0.4) {
                log.warn(generatePhrase(10, 30));
            } else if (r < 0.6) {
                log.info(generatePhrase(10, 30));
            } else if (r < 0.8) {
                log.debug(generatePhrase(10, 30));
            } else {
                log.trace(generatePhrase(10, 30));
            }
        }
    }

    private String generatePhrase(int minCount, int maxCount) {
        int count = faker.number().numberBetween(minCount, maxCount);
        StringWriter sw = new StringWriter();
        for (int i = 0; i < count; i++) {
            sw.append(faker.name().fullName());
            sw.append(" ");
        }
        return sw.toString();
    }
}
