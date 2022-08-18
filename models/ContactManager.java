package models;

import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager () {
        contacts = new ArrayList<Contact>();
    }

    /**
     * Name: getContact
     * 
     * Return a copy of a Contact from the ArrayList contacts
     * @param index (int)
     * @return (Contact)
     * 
     * Inside the function:
     *  1. Retrieve the object at the index argument
     *  2. Create a new copy of that object and return it to the user
     */
    public Contact getContact(int index){
        return new Contact(contacts.get(index));
    }

    /**
     * Name: setContact
     * @param index (int)
     * @param contact (Contact)
     * 
     * Inside the function:
     *  1. Create a new contact object based off of the contact passed in the argument
     *  2. Set the location at index in the ArrayList equal to the copy of the contact
     */
    public void setContact(int index, Contact contact){
        contacts.set(index, new Contact(contact));
    }

    /**
     * Name: addContact
     * @param contact
     * 
     * Inside the function:
     *  1. Create a copy of the contact passed as an argument 
     *  2. Add the copy to the end of the ArrayList contacts
     */
    public void addContact(Contact contact){
        contacts.add(new Contact(contact));
    }

    /**
     * Name: removeContact
     * @param contactName
     * 
     * Inside the function:
     *  1. Check if ArrayList contacts is empty - if so, throw exception
     *  2. Search for the contact that has the same name as the String contactName
     *  3. If found, remove that contact
     *  4. If not found, do not remove any contact
     */
    public void removeContact(String contactName){
        //Throw exception is the ArrayList is empty
        if (contacts.size() == 0){
            throw new IllegalStateException("You cannot remove a contact from an empty ArrayList");
        }
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(contactName)){
                contacts.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < contacts.size(); i++) {
            temp += contacts.get(i).toString() + "\n\n";
        }
        return temp;
    }
    
}
