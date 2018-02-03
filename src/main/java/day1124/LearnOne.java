package day1124;

import simpleProxy.RealObject;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LearnOne implements Serializable {
    private static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
    private static final long serialVersionUID = 1L;


    public static void main(String[] args) throws ClassNotFoundException {
        String dateEarly = sdf.format(new Date());
        Timestamp timestamp = Timestamp.valueOf(dateEarly+" 00:00:00");
        System.out.println(timestamp);
    }
}
