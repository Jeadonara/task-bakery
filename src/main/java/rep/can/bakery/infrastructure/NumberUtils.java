package rep.can.bakery.infrastructure;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class NumberUtils {
    public static final DecimalFormatSymbols SYMBOLS = new DecimalFormatSymbols(Locale.ENGLISH);

    private NumberUtils() {
    }

    public static String formatBigDecimal(BigDecimal bigDecimal, int scale) {
        DecimalFormat format = new DecimalFormat();
        format.setMinimumFractionDigits(scale);
        format.setMaximumFractionDigits(scale);
        format.setDecimalFormatSymbols(SYMBOLS);
        return bigDecimal != null ? format.format(bigDecimal) : null;
    }

}
