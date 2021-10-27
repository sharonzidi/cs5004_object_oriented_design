package regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tbonaci on 3/27/18.
 */
public class MainRE {

    public static void main(String[] args) {
        Pattern re1 = Pattern.compile("(c|cs)(5004|5010)*(,2018)*");

        Matcher matcher1 = re1.matcher("cs5004,2018");
        System.out.println(re1.pattern() + " on \"cs5004,2018\" matched? " + matcher1.matches());

        Matcher matcher2 = re1.matcher("cs6410,2018");
        System.out.println(re1.pattern() + " on \"cs6410,2018\" matched? " + matcher2.matches());

        System.out.println(re1.pattern() + " on \"c\" matched? " + re1.matcher("c").matches());

        System.out.println(re1.pattern() + " on \"cscscscs\" matched? " + re1.matcher("cscscscs").matches());


        Pattern re2 = Pattern.compile("(d*)([a-z]*)(l)");
        Matcher m = re2.matcher("ddaniel");

        if (m.matches()) {

            for (int i = 1; i <= 3; i++) {
                String s = String.format("Found \"%s\" starting at index %d ending at index %d", m.group(i)
                        , m.start(i), m.end(i));
                System.out.println(s);
            }
        }
    }
}
