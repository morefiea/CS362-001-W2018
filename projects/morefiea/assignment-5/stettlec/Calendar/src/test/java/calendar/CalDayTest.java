package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.Iterator;

import static org.junit.Assert.*;
public class CalDayTest {

    @Test
    public void testGetters() throws Throwable {

        GregorianCalendar day = new GregorianCalendar(1996, 10, 18);
        CalDay calday = new CalDay(day);

        assertEquals(1996, calday.getYear());
        assertEquals(10, calday.getMonth());
        assertEquals(18, calday.getDay());
        assertEquals(0, calday.getSizeAppts());
    }

    @Test
    public void testAddAppt() throws Throwable {

        GregorianCalendar day = new GregorianCalendar(1996, 10, 18);
        CalDay calday = new CalDay(day);
        Appt myAppt = new Appt(21, 55, 18, 10, 1996, "Birth", "Be born.");

        calday.addAppt(myAppt);

        Appt another = new Appt(23, 59, 18, 10, 1996, "Not birth", "Don't be born.");

        calday.addAppt(another);

        Appt third = new Appt(22, 50, 18, 10, 1996, "AAAAAAAAAAAAAA", "AAAAAAAAAAA");

        calday.addAppt(third);

        Appt ech = new Appt(20, 50, 18, 10, 1996, "nein danke!", "echt super!");

        calday.addAppt(ech);

        Iterator<?> itr = calday.iterator();

        Object element = itr.next();
        assertEquals(ech.toString(), element.toString());
        element = itr.next();
        assertEquals(myAppt.toString(), element.toString());
        element = itr.next();
        assertEquals(third.toString(), element.toString());
        element = itr.next();
        assertEquals(another.toString(), element.toString());
    }

    @Test
    public void testToString() throws Throwable {

        GregorianCalendar day = new GregorianCalendar(1996, 10, 18);
        CalDay calday = new CalDay(day);
        Appt myAppt = new Appt(21, 55, 18, 10, 1996, "Birth", "Be born.");

        calday.addAppt(myAppt);

        Iterator<Appt> itr = calday.appts.iterator();

        Object element = itr.next();
        assertEquals("\t --- 10/18/1996 --- \n --- -------- Appointments ------------ --- \n\t10/18/1996 at 9:55pm ,Birth, Be born.\n \n", calday.toString());
        //System.out.println(calday.toString());
    }
}