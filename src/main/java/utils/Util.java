package utils;

import java.math.BigDecimal;

/**
 * Created by Oleg on 07.11.2015.
 */
public class Util {

    public static double round(double value, int places) {
        return new BigDecimal(value)
                .setScale(places, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
    }
}
