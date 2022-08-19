import models.Contact;
import models.ContactManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

    //Make the ContactManager object a class variable
    public static ContactManager contactManager = new ContactManager();

    public static void main(String[] args){
        try{ 
            loadContacts("contacts.txt");
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        System.out.println("CONTACTS LOADED\n\n");
        System.out.println(contactManager);
        System.out.println("Process Complete");

        System.out.println("manageContacts");
        manageContacts();
        
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
    public static void manageContacts(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Would you like to \n\ta) add another contact\n\tb) remove a contact\n\tc) exit");
            String answer = scan.next();
            char answerChar = answer.charAt(0);
            answerChar = Character.toLowerCase(answerChar);
            if (answerChar == 'a'){
                System.out.print("\tName: ");
                scan.nextLine();
                String name = scan.nextLine();
                System.out.print("\tPhone number: ");
                String phoneNumber = scan.next();
                System.out.print("\tBirth date: ");
                String birthDate = scan.next();

                try {
                    contactManager.addContact(new Contact(name, phoneNumber, birthDate));
                } 
                catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
                finally{
                    System.out.println("\n\nUPDATED CONTACTS\n\n");
                    System.out.println(contactManager);
                }

            } else if (answerChar == 'b'){
                System.out.println("\nWho would you like to remove?");
                String nameToRemove = scan.next();
                contactManager.removeContact(nameToRemove);
                System.out.println("\n\nUPDATED CONTACTS\n\n");
                System.out.println(contactManager);
            } else if (answerChar == 'c'){
                break;
            } else {
                System.out.println("Incorrect input, please try again");
            }
        }
        scan.close();
    }



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
    public static void loadContacts (String fileName) throws FileNotFoundException{
        //Load contacts from fileName

        //FIRST - need to create a new file
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        while(scan.hasNext()){
            String name = scan.next();
            String phoneNumber = scan.next();
            String dateOfBirth = scan.next();
            try{
                contactManager.addContact(new Contact(name, phoneNumber, dateOfBirth));
            }
            catch (ParseException e){
                System.out.println(e.getMessage());
            }
        }
        scan.close();
    }

}
