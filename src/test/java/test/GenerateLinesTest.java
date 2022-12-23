package test;

import java.io.StringWriter;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.datafaker.Faker;

public class GenerateLinesTest {

    private Logger log = LoggerFactory.getLogger(getClass());
    
    private final static String LOG_PATTERN = "[{}/{}] {}";

    Faker faker = new Faker();

    @Test
    public void generateLines() throws Exception {
        int numberOfLines = Integer.valueOf(System.getProperty("faker.count", "10"));
        int sleepMin = Integer.valueOf(System.getProperty("faker.sleepMin", "50"));
        int sleepMax = Integer.valueOf(System.getProperty("faker.sleepMax", "80"));
        
        log.info("*** Generating {} lines, with sleepMin={} and sleepMax={}", numberOfLines, sleepMin, sleepMax);
        
        for (int i = 1; i <= numberOfLines; i++) {
            double r = Math.random();
            if (r < 0.2) {
                log.error("[{}/{}] {}", i, numberOfLines, generatePhrase(10, 30));
            } else if (r < 0.4) {
                log.warn("[{}/{}] {}", i, numberOfLines, generatePhrase(10, 30));
            } else if (r < 0.6) {
                log.info("[{}/{}] {}", i, numberOfLines, generatePhrase(10, 30));
            } else if (r < 0.8) {
                log.debug("[{}/{}] {}", i, numberOfLines, generatePhrase(10, 30));
            } else {
                log.trace("[{}/{}] {}", i, numberOfLines, generatePhrase(10, 30));
            }
            Thread.sleep(faker.number().numberBetween(sleepMin, sleepMax));
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
