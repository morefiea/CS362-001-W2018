package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {

    //Tests the getter functions.
	@Test
	public void testGetters()  throws Throwable  {
		Appt myAppt = new Appt(5, 5, 5, 5, 2018, "Drink Water", "Remember to drink some water.");
		
		assertEquals(5, myAppt.getStartHour());
		assertEquals(5, myAppt.getStartMinute());
		assertEquals(5, myAppt.getStartDay());
		assertEquals(5, myAppt.getStartMonth());
		assertEquals(2018, myAppt.getStartYear());
		assertEquals("Drink Water", myAppt.getTitle());
		assertEquals("Remember to drink some water.", myAppt.getDescription());
	}

	//Tests the sett functions.
	@Test
	public void testSetters() throws Throwable {
		Appt myAppt = new Appt(5, 5, 5, 5, 2018, "Drink Water", "Remember to drink some water.");
		
		myAppt.setStartHour(4);
		myAppt.setStartMinute(4);
		myAppt.setStartDay(4);
		myAppt.setStartMonth(4);
		myAppt.setStartYear(2017);
		myAppt.setTitle("Eat Food");
		myAppt.setDescription("Remember to eat some food.");
		
		assertEquals(4, myAppt.getStartHour());
		assertEquals(4, myAppt.getStartMinute());
		assertEquals(4, myAppt.getStartDay());
		assertEquals(4, myAppt.getStartMonth());
		assertEquals(2017, myAppt.getStartYear());
		assertEquals("Eat Food", myAppt.getTitle());
		assertEquals("Remember to eat some food.", myAppt.getDescription());
	}

	//Tests the isValid() function.
	@Test
    public void testIsValid() throws Throwable {
        Appt myAppt = new Appt(5, 5, 5, 5, 2018, "Drink Water", "Remember to drink some water.");

        assertEquals(true, myAppt.getValid());

        myAppt.setStartHour(0);
        myAppt.setStartMinute(0);
        myAppt.setStartDay(1);
        myAppt.setStartMonth(1);

        assertEquals(true, myAppt.getValid());

        myAppt.setStartHour(23);
        myAppt.setStartMinute(59);
        myAppt.setStartDay(31);
        myAppt.setStartMonth(12);

        assertEquals(true, myAppt.getValid());

        myAppt.setStartHour(24);
        myAppt.setStartMinute(60);
        myAppt.setStartDay(32);
        myAppt.setStartMonth(13);

        assertEquals(true, myAppt.getValid());

        myAppt.setStartHour(100);
        myAppt.setStartMinute(100);
        myAppt.setStartDay(100);
        myAppt.setStartMonth(100);

        assertEquals(false, myAppt.getValid());
    }

    //Tests the recurrance feature.
    @Test
    public void testReccurence() throws Throwable {
	    int[] arr = {5, 5, 5};
        Appt myAppt = new Appt(5, 5, 5, 5, 2018, "Drink Water", "Remember to drink some water.");
        myAppt.setRecurrence(arr,5, 5, 5);

        assertEquals(5, myAppt.getRecurNumber());
        assertEquals(5, myAppt.getRecurIncrement());
        assertEquals(5, myAppt.getRecurBy());
        assertEquals(true, myAppt.isRecurring());
    }
}
