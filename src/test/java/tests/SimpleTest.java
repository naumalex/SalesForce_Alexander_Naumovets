package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class SimpleTest {
    @Test
    public void test2() {
       // Car car = new  Car("bmw", "7", 20000);
       // log.fatal("Fatal");
        log.error("Error");
        log.warn("Warn");
        log.info("Info");
        log.debug("Debug");
        log.trace("Trace");
        /*try {
            throw new StaleElementReferenceException( )
        }*/
    }
}
