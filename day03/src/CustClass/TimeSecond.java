package CustClass;

public class TimeSecond {

    public static int Second_time() {
        long l = System.currentTimeMillis();
        String s = String.valueOf(l);
        String time = s.substring(0, s.length() - 3);
        int datetime = Integer.parseInt(time);
        return datetime;
    }
}
