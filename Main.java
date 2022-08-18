import models.Contact;

public class Main {
    public static void main(String[] args){

        //Testing code to ensure that creating a contact works
        try {
            Contact contact1 = new Contact("Alan Turing", "6139874561", "07/23/1912");

            //Testing toString
            System.out.println(contact1);

            //Testing getters
            System.out.println("Testing Getters");
            System.out.println("Get Name: " + contact1.getName());
            System.out.println("Get Phone Number: " + contact1.getPhoneNumber());
            System.out.println("Get Birth Date: " + contact1.getBirthDate());
            System.out.println("Get Age: " + contact1.getAge());
            System.out.println("\n\n");

            //Testing code to create a new contact from the old one, and update the old one without affecting the new one
            Contact contact2 = new Contact(contact1);
            System.out.println(contact2);

            System.out.println("\n\nChanging birthdates for each\n\n");

            //Testing code to ensure that setting the birthdate works (check with debugger)
            contact1.setBirthDate("07/23/2000");
            contact2.setBirthDate("12/31/1989");

            System.out.println(contact1);
            System.out.println(contact2);

            //Uncomment to test an unparseable date
            //Contact exceptionContact = new Contact("Alan Turing", "6139874561", "23/07/1912");

            //Uncomment to test illegal arguments to contact constructor
            //Contact contactErr1 = new Contact(null, "6139874561", "07/23/1912");
            //Contact contactErr2 = new Contact("", "6139874561", "07/23/1912");
            //Contact contactErr3 = new Contact("Alan Turing", null, "07/23/1912");
            //Contact contactErr4 = new Contact("Alan Turing", "", "07/23/1912");
            //Contact contactErr5 = new Contact("Alan Turing", "123", "07/23/1912");

            contact1.setName("Charles Darwin");
            System.out.println(contact1);

            contact1.setPhoneNumber("8885551111");
            System.out.println(contact1);

            //Uncomment to test illegal arguments to setName
            //contact1.setName(null);
            //contact1.setName("");


            //Uncomment to test illegal arguments to setPhoneNumber
            //contact1.setPhoneNumber(null);
            //contact1.setPhoneNumber("");
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Process Complete");
        
        
    }

    /**
     * Name: manageContacts
     *
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) add b) remove a contact c) exit.
     *   •        case a: ask for the name, phone number and birthDate.
     *   •        case b: ask who they'd like to remove.
     *   •        case c: break the loop.
     *   • 3. close Scanner.
     */



    /**
     * Name: loadContacts
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads contacts from <fileName>;
     *   • 2. From the manager object, it adds all contacts to the contacts list.
     *        Hint: use scan.next to grab the next String separated by white space.
     */

}
