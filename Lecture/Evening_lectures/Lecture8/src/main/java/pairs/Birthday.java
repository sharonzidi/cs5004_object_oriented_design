package pairs;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Birthday extends Triple<String, Integer, Integer> implements Comparable<Birthday> {
    public Birthday(String month, Integer day, Integer year) {
        super(month, day, year);
    }

    public String getMonth() {
        return super.getFirst();
    }

    public Integer getDay() {
        return super.getSecond();
    }

    public Integer getYear() {
        return super.getThird();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Birthday birthday = (Birthday) o;
        return this.first.equals(birthday.first) &&
                this.second.equals(birthday.second) &&
                this.third.equals(birthday.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public String toString() {
        return this.getMonth() + " " + this.getDay() + " " + this.getYear();
    }

    private int monthToInt(String month) {
        Map<String, Integer> months = new HashMap<String, Integer>() {{
            put("Jan", 1);
            put("Feb", 2);
            put("Mar", 3);
            put("Apr", 4);
            put("May", 5);
            put("Jun", 6);
            put("Jul", 7);
            put("Aug", 8);
            put("Sep", 9);
            put("Oct", 10);
            put("Nov", 11);
            put("Dec", 12);
        }};
        return months.get(month);
    }

    @Override
    public int compareTo(Birthday o) {
        int thisMonth = this.monthToInt(this.getMonth());
        int thatMonth = this.monthToInt(o.getMonth());
        if (this.equals(o))
            return 0;
        if (this.getYear() < o.getYear() ||
                this.getYear().equals(o.getYear()) &&
                        (thisMonth < thatMonth || thisMonth == thatMonth && this.getDay().compareTo(o.getDay()) < 0))
            return -1;
        else return 1;

    }

}
