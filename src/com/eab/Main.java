package com.eab;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("+94 71 211 0640");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printInstructions();
        while (!quit) {
            System.out.println("\nEnter action: (6 to show instructions) ");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {

                case 0:
                    System.out.println("\nShutting down");
                    quit = true;
                    break;

                case 1:
                    mobilePhone.printContact();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryContact();
                    break;

                case 6:
                    printInstructions();
                    quit = true;
                    break;
            }
        }
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printInstructions() {
        System.out.println("\nAvailable Actions \npress:");
        System.out.println(
                "0: Exit\n" +
                "1: print contacts\n" +
                "2: add a new contact\n" +
                "3: update an existing contact\n" +
                "4: remove an existing contact\n" +
                "5: query an existing contact\n" +
                "6: print available actions");
        System.out.println("Choose an action: ");
    }


    private static void addNewContact(){
        System.out.print("Enter new contact name");
        String contactName = scanner.nextLine();
        System.out.print("Enter new contact phone number");
        String phoneNumber = scanner.nextLine();

        Contact newContact=Contact.createContact(contactName, phoneNumber);
        if(mobilePhone.addContact(newContact)){
            System.out.println("New contact added, Name: " + newContact.getName() +
                    ", Phone number: " + newContact.getPhoneNumber());
        }
        else {
            System.out.println("Contact name " + newContact.getName() + "  already been added");
        }
    }

    private static void updateContact(){
        System.out.println("Enter the name to be modified: ");
        String oldName = scanner.nextLine();
        Contact contact=mobilePhone.queryContact(oldName);
        if (contact!=null){
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter phone number: ");
            String newPhoneNumber = scanner.nextLine();

            Contact newContact = Contact.createContact(newName, newPhoneNumber);
            mobilePhone.modifyContact(contact, newContact);
            return;
        }
        System.out.println("No existing contact name found");
        return;
    }

    private static void removeContact(){
        System.out.println("Enter the contact name to be removed: ");
        String name = scanner.nextLine();
        Contact contact=mobilePhone.queryContact(name);
        mobilePhone.removeContact(contact);
    }

    private static void queryContact(){
        System.out.println("Enter the contact name to be querried: ");
        String name = scanner.nextLine();
        Contact contact=mobilePhone.queryContact(name);
        if (contact!=null){
            System.out.println("Contact found, " +
                    "Name: " + contact.getName() + " Phone: " + contact.getPhoneNumber());
        }
    }

}

