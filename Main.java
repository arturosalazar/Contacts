import models.Contact;
import models.ContactManager;

public class Main {
    public static void main(String[] args){

        //Test that contact manager works
        ContactManager contactManager = new ContactManager();
        try {
            contactManager.addContact(new Contact("Ryan", "6135012424", "11/11/1992"));    
            contactManager.addContact(new Contact("Gio", "6477092344", "11/11/1993"));    
            contactManager.addContact(new Contact("Thomas", "8192256979", "11/11/1994"));    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(contactManager);
        
        //Test that removeContact method of contact manager works
        System.out.println("Removing Gio\n");
        contactManager.removeContact("Gio");
        System.out.println(contactManager);

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
