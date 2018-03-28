package question6.pkg;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This is a proof of concept, to show some values of following math statement:
 * Let a and b be positive integers such that ab + 1 divides a2 + b2. Show that
 * a2 + b2 / ab + 1 is the square of an integer.
 *
 * @author Alex
 */
public class Question6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BigDecimal res;
        int it_i = 10000, it_j = 10000; //MAX: 46340, because int can only have that number safely squared (a^2 or b^2)
        int a_pow_2, part_2;
        long part_1; // This one can potentially go over int (a^2 + b^2)
        int precision = 12;
        int num = 0;

        for (int a = 1; a < it_i; a++) {
            a_pow_2 = a * a;

            for (int b = a; b < it_j; b++) {
                part_1 = a_pow_2 + (b * b);
                part_2 = (a * b) + 1;

                res = (new BigDecimal(part_1).divide(new BigDecimal(part_2), precision, RoundingMode.HALF_UP)).stripTrailingZeros();

                if (res.scale() <= 0) {
                    num++;
                    System.out.println("a = " + a + ", b = " + b + ", Result = " + res.toPlainString());
                }
            }
        }
        System.out.println("Numbers calculated: " + num);
    }
}
