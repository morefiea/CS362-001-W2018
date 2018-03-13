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

        assertEquals(0, myAppt.getRecurNumber());
        assertEquals(0, myAppt.getRecurIncrement());
        assertEquals(2, myAppt.getRecurBy());
        assertEquals(false, myAppt.isRecurring());
	}

	//Tests the sett functions.
	@Test
	public void testSetters() throws Throwable {
		Appt myAppt = new Appt(5, 5, 5, 5, 2018, "Drink Water", "Remember to drink some water.");
		
		myAppt.setStartHour(4);
		myAppt.setStartMinute(4);
		myAppt.setStartDay(29);
		myAppt.setStartMonth(2);
		myAppt.setStartYear(2000);
		myAppt.setTitle("Eat Food");
		myAppt.setDescription("Remember to eat some food.");
		
		assertEquals(4, myAppt.getStartHour());
		assertEquals(4, myAppt.getStartMinute());
		assertEquals(29, myAppt.getStartDay());
		assertEquals(2, myAppt.getStartMonth());
		assertEquals(2000, myAppt.getStartYear());
		assertEquals("Eat Food", myAppt.getTitle());
		assertEquals("Remember to eat some food.", myAppt.getDescription());

		myAppt.setStartHour(99999999);
		assertEquals(false, myAppt.getValid());
        myAppt.setStartHour(4);
        myAppt.setStartMinute(99999999);
        assertEquals(false, myAppt.getValid());
        myAppt.setStartMinute(4);
        myAppt.setStartDay(99999999);
        assertEquals(false, myAppt.getValid());
        myAppt.setStartDay(29);
        myAppt.setStartYear(2001);
        assertEquals(false, myAppt.getValid());

	}

	//Tests the isValid() function.
	@Test
    public void testIsValid() throws Throwable {
        Appt myAppt = new Appt(0, 0, 1, 1, 0, "Drink Water", "Remember to drink some water.");

        assertEquals(true, myAppt.getValid());

        for (int i = 0; i < 50; i++) {
            myAppt.setStartHour(i);
            myAppt.setStartMinute(0);
            myAppt.setStartDay(1);
            myAppt.setStartMonth(1);

            if (i < 0 || i > 23) assertEquals(false, myAppt.getValid());
            else assertEquals(true, myAppt.getValid());
        }

        for (int i = 0; i < 100; i++) {
            myAppt.setStartHour(0);
            myAppt.setStartMinute(i);
            myAppt.setStartDay(1);
            myAppt.setStartMonth(1);

            if (i < 0 || i > 59) assertEquals(false, myAppt.getValid());
            else assertEquals(true, myAppt.getValid());
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 1; j <= 12; j++) {
                int NumDaysInMonth= CalendarUtil.NumDaysInMonth(2000, j-1);

                myAppt.setStartHour(0);
                myAppt.setStartMinute(0);
                myAppt.setStartDay(i);
                myAppt.setStartMonth(j);

                if (i < 1 || i > NumDaysInMonth) assertEquals(false, myAppt.getValid());
                else assertEquals(true, myAppt.getValid());
            }
        }

        myAppt.setStartHour(24);
        myAppt.setStartMinute(60);
        myAppt.setStartDay(32);
        myAppt.setStartMonth(12);
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

        myAppt.setRecurrence(null, 5, 5, 5);

        //assertEquals(0, myAppt.getRecurDays()[0]);
        assertEquals(0, myAppt.getRecurDays().length);
    }

    @Test
    public void testToString() throws Throwable {
        Appt myAppt = new Appt(5, 0, 5, 5, 2018, "Drink Water", "Remember to drink some water.");

        assertEquals("\t5/5/2018 at 5:0am ,Drink Water, Remember to drink some water.\n", myAppt.toString());

        myAppt.setStartHour(11);
        assertEquals("\t5/5/2018 at 11:0am ,Drink Water, Remember to drink some water.\n", myAppt.toString());

        myAppt.setStartHour(12);
        assertEquals("\t5/5/2018 at 12:0pm ,Drink Water, Remember to drink some water.\n", myAppt.toString());

        myAppt.setStartHour(13);
        assertEquals("\t5/5/2018 at 1:0pm ,Drink Water, Remember to drink some water.\n", myAppt.toString());

        Appt myAppt2 = new Appt(999, 5, 5, 5, 2018, "Drink Water", "Remember to drink some water.");

        assertEquals(null, myAppt2.toString());
    }

    @Test
    public void testCompareTo() throws Throwable {
        Appt myAppt = new Appt(5, 5, 5, 5, 2018, "Drink Water", "Remember to drink some water.");
        Appt myAppt2 = new Appt(5, 5, 5, 5, 2018, "Drink Water", "Remember to drink some water.");

        assertEquals(0, myAppt.compareTo(myAppt2));

        Appt myAppt3 = new Appt(5, 5, 5, 5, 2018, "Drink Water", "Remember to drink some water.");
        Appt myAppt4 = new Appt(6, 6, 6, 6, 2019, "Drink Water", "Remember to drink some water.");

        assertEquals(5, myAppt4.compareTo(myAppt3));
    }
}