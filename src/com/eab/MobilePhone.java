package com.eab;

import com.sun.java.swing.plaf.motif.MotifFileChooserUI;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contact> contacts;
    private String myNumber;

    MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contacts = new ArrayList<>();
    }

    public boolean addContact(Contact contact) {
        int position = findContact(contact.getName());
        if (position == -1) {
            contacts.add(contact);
            System.out.println("Contact added");
            return true;
        } else {
            System.out.println("Contact have saved already");
            return false;
        }

    }


    public boolean modifyContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position != -1) {
            this.contacts.set(position, newContact);
            System.out.println("Contact modified successfully");
            return true;
        }
        System.out.println("Contact not found to modify");
        return false;
    }

    public void removeContact(Contact contact) {
        int position = findContact(contact);
        if (position != -1) {
            contacts.remove(position);
            System.out.println("Contact removed successfully");
        } else {
            System.out.println("No existing contact ");
        }
    }

    public void printContact() {
        System.out.println("Contact list");
        for (int i = 0; i < this.contacts.size(); i++) {
            Contact contact = this.contacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " ==> " + contact.getPhoneNumber());
        }
    }

    private int findContact(Contact contact) {
        return this.contacts.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = this.contacts.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact) {
        int position = findContact(contact);
        if (position != -1) {
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if (position!=-1){
            return this.contacts.get(position);
        }
        return null;
    }
}
