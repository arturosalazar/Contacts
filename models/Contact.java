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

    /**
     * Name: Contact - Constructor
     * @param name
     * @param phoneNumber
     * @param birthDate
     * @throws ParseException
     * 
     * Inside Function:
     *  1. Updates the name, phone number and birthDate of the function
     *  2. Updates the age of the contact based off of the birthDate by calling calculateAge
     */
    public Contact (String name, String phoneNumber, String birthDate) throws ParseException {

        //Check for illegal arguments - if provided, throw an IllegalArgumentException
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }

        if (phoneNumber == null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Phone number cannot be null or blank");
        }

        if (phoneNumber.length() < 5) {
            throw new IllegalArgumentException("Phone number must be greater than 5 characters");
        }

        //update the name, phone, and birthDate
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;

        //Calculate age and set it 
        this.age = calculateAge(birthDate);
    }

    /**
     * Name: Contact - Copy Constructor
     * @param source
     * Inside Function:
     *  1. Creates a new Contact object by copying the source Contact object's fields
     */
    public Contact (Contact source){
        this.name = source.name;
        this.phoneNumber = source.phoneNumber;
        this.birthDate = source.birthDate;
        this.age = source.age;

    }


    /**
     * Name: calculateAge
     * @param birthDate
     * @return age (int)
     * @throws ParseException
     * 
     * Inside the function:
     *  1. Parses a date from the birthDate String
     *  2. Gets the current date
     *  3. Subtracts the difference and returns the age
     */
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

    public void setName(String name) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Phone number cannot be null or blank");
        }
        this.phoneNumber = phoneNumber;
    }

    private void setAge(String birthDate) throws ParseException{
        this.age = calculateAge(birthDate);
    }


    //Will update the birthdate field and simultaneously update the age of the object
    public void setBirthDate (String birthDate) throws ParseException {
        this.birthDate = birthDate;
        setAge(birthDate);

    }

    @Override
    public String toString() {
        String temp = "Name: " + this.name + "\n"
            + "Phone number: " + this.phoneNumber  + "\n"
            + "Birth Date: " + this.birthDate  + "\n"
            + "Age: " + this.age  + " year old\n";

        return temp;
    }


}
