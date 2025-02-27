package com.contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    public boolean addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            return false; // Contact ID must be unique
        }
        contacts.put(contact.getContactID(), contact);
        return true;
    }

    public boolean deleteContact(String contactID) {
        if (contacts.containsKey(contactID)) {
            contacts.remove(contactID);
            return true;
        }
        return false;
    }

    public boolean updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        if (!contacts.containsKey(contactID)) {
            return false;
        }
        Contact contact = contacts.get(contactID);
        if (firstName != null && !firstName.isEmpty()) {
            contact.setFirstName(firstName);
        }
        if (lastName != null && !lastName.isEmpty()) {
            contact.setLastName(lastName);
        }
        if (phone != null && !phone.isEmpty()) {
            contact.setPhone(phone);
        }
        if (address != null && !address.isEmpty()) {
            contact.setAddress(address);
        }
        return true;
    }

    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}