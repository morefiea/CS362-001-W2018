package calendar;


import org.junit.Test;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS=100;
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	@Test
	public void randomtest()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
				Random random = new Random(randomseed);

				int startHour=ValuesGenerator.RandInt(random);
				int startMinute=ValuesGenerator.RandInt(random);
				int startDay=ValuesGenerator.RandInt(random);;
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear=ValuesGenerator.RandInt(random);
				String title="Birthday Party";
				String description="This is my birthday party.";
				//Construct a new Appointment object with the initial data
				Appt appt = new Appt(startHour,
						startMinute ,
						startDay ,
						startMonth ,
						startYear ,
						title,
						description);

                GregorianCalendar g = new GregorianCalendar(2018, 2, 26);

                CalDay c = new CalDay(g);

				if(!appt.getValid())continue;
				for (int i = 0; i < NUM_TESTS; i++) {


                    randomseed =System.currentTimeMillis(); //10
                    random = new Random(randomseed);

                    startHour = ValuesGenerator.getRandomIntBetween(random, -1, 24);
                    startMinute = ValuesGenerator.getRandomIntBetween(random, -1, 60);
                    startDay = 26;
                    startMonth = 2;
                    startYear = 2018;
                    title = "" + (char)ValuesGenerator.RandInt(random) + (char)ValuesGenerator.RandInt(random) + (char)ValuesGenerator.RandInt(random);

                    appt = new Appt(startHour,
                            startMinute ,
                            startDay ,
                            startMonth ,
                            startYear ,
                            title,
                            description);

                    int length = c.getAppts().size();

                    c.addAppt(appt);

                    if (appt.getValid()) {
                        assertEquals(length + 1, c.getAppts().size());
                    }
                    else assertEquals(length, c.getAppts().size());
				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		System.out.println("Done testing...");
	}


	
}