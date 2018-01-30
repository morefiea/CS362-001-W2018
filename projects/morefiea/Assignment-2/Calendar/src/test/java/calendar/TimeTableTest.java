package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.Assert.*;
public class TimeTableTest {

    @Test
    public void testGetApptRange() throws Throwable {
        GregorianCalendar startday = new GregorianCalendar(1996, 10, 18);
        GregorianCalendar endday = new GregorianCalendar(1996, 10, 20);

        Appt birth = new Appt(21, 55, 18, 10, 1996, "Birth", "Be born.");
        Appt breathe = new Appt(23, 59, 19, 10, 1996, "Breathe", "Remember to breathe");

        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(birth);
        appts.add(breathe);

        TimeTable times = new TimeTable();
        LinkedList<CalDay> days;

        days = times.getApptRange(appts, startday, endday);

        assertEquals(2, days.size());

        Iterator<Appt> itr1 = days.get(0).appts.iterator();

        Object element = itr1.next();
        assertEquals(birth.toString(), element.toString());

        Iterator<Appt> itr2 = days.get(1).appts.iterator();

        Object element2 = itr2.next();
        assertEquals(breathe.toString(), element2.toString());
    }

    @Test
    public void testDeleteAppt() throws Throwable {
        GregorianCalendar startday = new GregorianCalendar(1996, 10, 18);
        GregorianCalendar endday = new GregorianCalendar(1996, 10, 20);

        Appt birth = new Appt(21, 55, 18, 10, 1996, "Birth", "Be born.");
        Appt breathe = new Appt(22, 58, 19, 10, 1996, "Breathe", "Remember to breathe");

        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(birth);
        appts.add(breathe);

        TimeTable times = new TimeTable();
        LinkedList<Appt> appts2;
        LinkedList<Appt> appts3;

        appts2 = times.deleteAppt(appts, breathe);

        assertEquals(1, appts2.size());

        appts3 = times.deleteAppt(appts2, birth);

        assertEquals(0, appts3.size());
    }
}