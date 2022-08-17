package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Contact {
    private String name;
    private String phoneNumber;
    private String birthDate;
    private int age;

    //Constructor will only get name, phone number, and birth date
    public Contact (String name, String phoneNumber, String birthDate) throws ParseException {
        //update the name, phone, and birthDate
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;

        //Calculate age and set it 
        this.age = calculateAge(birthDate);
    }

    private int calculateAge (String birthDate) throws ParseException {

        //Create an object of the SimpleDateFormat class
        SimpleDateFormat yearFormat = new SimpleDateFormat("MM/dd/yyyy");
        //Set SimpleDateFormat object to lenient to throw an exception if there's an issue
        yearFormat.setLenient(false);
 
 
        //Get the current time as a Date object
        Date currentDate = new Date();
          
        //Use the SimpleDateFormat object (yearFormat) to parse() a Date from the birthDate String
        Date dateOfBirth = yearFormat.parse(birthDate);
        
        //Get the milliseconds from 1970 to each date, then subtract to get the time period between the dates
        long currentDateMS = currentDate.getTime();
        long dateOfBirthMS = dateOfBirth.getTime();
        long timeBetweenMS = currentDateMS - dateOfBirthMS;
 
        //Use TimeUnit to convert the time between dates in MS to Days and divide by 365 to convert to years
        long timeBetweenInDays = TimeUnit.DAYS.convert(timeBetweenMS, TimeUnit.MILLISECONDS);
        long timeBetweenInYears = timeBetweenInDays / 365;
 
        //convert the long value of years into an int value and return
        int yearsDiffernce = (int) timeBetweenInYears;
        return yearsDiffernce;

    }

}
