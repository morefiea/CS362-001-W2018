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
        int[] arr = {5, 5, 5};
        Appt myAppt = new Appt(23, 59, 19, 10, 1996, "Drink Water", "Remember to drink some water.");
        myAppt.setRecurrence(arr,1, 1, 1);

        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(birth);
        appts.add(myAppt);

        TimeTable times = new TimeTable();
        LinkedList<CalDay> days;

        days = times.getApptRange(appts, startday, endday);

        assertEquals(2, days.size());

        Iterator<Appt> itr1 = days.get(0).appts.iterator();

        Object element = itr1.next();
        assertEquals(birth.toString(), element.toString());

        Iterator<Appt> itr2 = days.get(1).appts.iterator();

        Object element2 = itr2.next();
        assertEquals(myAppt.toString(), element2.toString());
    }

    @Test
    public void testDeleteAppt() throws Throwable {
        GregorianCalendar startday = new GregorianCalendar(1996, 10, 18);
        GregorianCalendar endday = new GregorianCalendar(1996, 10, 20);

        Appt birth = new Appt(21, 55, 18, 10, 1996, "Birth", "Be born.");
        Appt breathe = new Appt(22, 58, 19, 10, 1996, "Breathe", "Remember to breathe");
        Appt blec = new Appt(22, 999, 19, 10, 1996, "bleck", "blec");

        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(birth);
        appts.add(breathe);

        TimeTable times = new TimeTable();
        LinkedList<Appt> appts2;
        LinkedList<Appt> appts3;
        LinkedList<Appt> appts4;
        appts2 = times.deleteAppt(appts, birth);
        assertEquals(1, appts2.size());

        appts3 = times.deleteAppt(appts2, breathe);

        assertEquals(0, appts3.size());

        appts4 = times.deleteAppt(appts3, null);
        assertEquals(null, appts4);

        appts3.add(blec);
        appts4 = times.deleteAppt(appts3, null);
        assertEquals(null, appts4);

        appts4 = times.deleteAppt(appts3, blec);
        assertEquals(null, appts4);

        appts4 = times.deleteAppt(appts3, birth);
        assertEquals(null, appts4);
    }

    @Test
    public void testPermute() throws Throwable {
        GregorianCalendar startday = new GregorianCalendar(1996, 10, 18);
        GregorianCalendar endday = new GregorianCalendar(1996, 10, 20);

        Appt birth = new Appt(21, 55, 18, 10, 1996, "Birth", "Be born.");
        Appt breathe = new Appt(22, 58, 19, 10, 1996, "Breathe", "Remember to breathe");
        Appt och = new Appt(23, 57, 19, 10, 1996, "Och", "Och");

        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(birth);
        appts.add(breathe);
        appts.add(och);

        TimeTable times = new TimeTable();
        int p[] = {2, 1, 0};
        LinkedList<Appt> appts2;

        appts2 = times.permute(appts, p);

        assertEquals("Och", appts2.get(0).getTitle());

        int c[] = {0, 1, 2};
        appts2 = times.permute(appts, c);

        assertEquals("Birth", appts2.get(0).getTitle());

        int d[] = {1, 0, 2};
        appts2 = times.permute(appts, d);

        assertEquals("Breathe", appts2.get(0).getTitle());

        int e[] = {0, 2, 1};
        appts2 = times.permute(appts, e);

        assertEquals("Birth", appts2.get(0).getTitle());
    }
}