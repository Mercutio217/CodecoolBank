import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.*;

/**
 * Created by mercutio on 06.06.17.
 */
public class SeedTest {

    @Test
    @DisplayName("Check if Seed enum has proper values")
    void testIfEnumHasProperValues() {
        Seed exampleEnum = Seed.CROSS;
        Seed[] constans = {Seed.EMPTY, Seed.CROSS, Seed.NOUGHT};
        assertEquals(constans, exampleEnum.getDeclaringClass().getEnumConstants());
    }

}