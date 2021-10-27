package timing;

public class Main {
    public static void main(String[] args) {
        String path = "country_codes.csv";
        IReadFile basic = new ReadBasic();
        IReadFile buffered = new ReadBuffered();
        IReadFile nio = new ReadNIO();
        System.out.println(basic.readAndTime(path));
        System.out.println(buffered.readAndTime(path));
        System.out.println(nio.readAndTime(path));
    }
}
