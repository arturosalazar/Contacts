import models.Contact;

public class Main {
    public static void main(String[] args){

        //Testing code to ensure that creating a contact works
        try {
            Contact contact1 = new Contact("Alan Turing", "6139874561", "07/23/1912");
            
            //Testing code to ensure that setting the birthdate works (check with debugger)
            contact1.setBirthDate("07/23/2000");
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
