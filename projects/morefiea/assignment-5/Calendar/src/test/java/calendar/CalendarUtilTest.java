package calendar;

import org.junit.Test;

import static calendar.CalendarUtil.IsLeapYear;
import static calendar.CalendarUtil.NumDaysInMonth;
import static org.junit.Assert.*;

public class CalendarUtilTest {
    @Test
    public void testIsLeapYear() throws Throwable {
        for (int i = 400; i < 5000; i++) {
            if ((i % 100) == 0) {

                if((i % 400) == 0) assertEquals(true, IsLeapYear(i));
                else assertEquals(false, IsLeapYear(i));
            }
            else if ((i % 4) == 0) assertEquals(true, IsLeapYear(i));
            else assertEquals(false, IsLeapYear(i));
        }
    }

    @Test
    public void testDaysInMonth() throws Throwable {
        int DaysInMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 0; i < 5000; i++) {

            for (int j = 0; j < 12; j++) {

                int baseDays = DaysInMonth[j];

                if (IsLeapYear(i) && (j == 1)) {
                    baseDays = baseDays + 1;
                }

                assertEquals(baseDays, NumDaysInMonth(i, j));
            }
        }
    }
}