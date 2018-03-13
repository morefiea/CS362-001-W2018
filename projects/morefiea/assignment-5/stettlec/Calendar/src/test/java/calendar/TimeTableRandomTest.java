package calendar;


import org.junit.Test;


import java.util.*;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class TimeTableRandomTest{
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

       // try{
            for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                long randomseed =System.currentTimeMillis(); //10
                Random random = new Random(randomseed);

                for (int i = 0; i < NUM_TESTS; i++) {

                    int m = ValuesGenerator.getRandomIntBetween(random, 0, 1);

                    if (m == 0){

                        GregorianCalendar startday = new GregorianCalendar(1996, 10, 18);
                        GregorianCalendar endday = new GregorianCalendar(1996, 10, 20);

                        Appt birth = new Appt(ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random), 18, 10, 1996, "Birth", "Be born.");
                        Appt breathe = new Appt(ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random), 19, 10, 1996, "Breathe", "Remember to breathe");
                        Appt blec = new Appt(ValuesGenerator.RandInt(random), 999999, 19, 10, 1996, "bleck", "blec");

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

                        appts4 = times.deleteAppt(null, birth);
                        assertEquals(null, appts4);
                    }

                    else {

                        GregorianCalendar startday = new GregorianCalendar(1996, 10, 18);
                        GregorianCalendar endday = new GregorianCalendar(1996, 10, 20);

                        Appt birth = new Appt(ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random), 18, 10, 1996, "Birth", "Be born.");
                        int[] arr = {5, 5, 5};
                        Appt myAppt = new Appt(ValuesGenerator.RandInt(random), ValuesGenerator.RandInt(random), 19, 10, 1996, "Drink Water", "Remember to drink some water.");
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

                }

                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                if((iteration%10000)==0 && iteration!=0 )
                    System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

            }
       // }catch(NullPointerException e){

       // }

        System.out.println("Done testing...");
    }



}