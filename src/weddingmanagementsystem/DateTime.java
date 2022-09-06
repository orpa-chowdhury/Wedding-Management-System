package weddingmanagementsystem;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 *
 * @author Orpa, Nushrat, Nur;
 */
public class DateTime {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public static void main(String[] args) {
        DateTime d = new DateTime();
 
    }

    public String getdate() {
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
