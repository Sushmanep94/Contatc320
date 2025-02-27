package com.contactTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.contact.Contact;
import com.contact.ContactService;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertTrue(contactService.addContact(contact));
        assertFalse(contactService.addContact(contact)); // Duplicate ID
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertTrue(contactService.deleteContact("12345"));
        assertFalse(contactService.deleteContact("67890")); // Non-existent ID
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertTrue(contactService.updateContact("12345", "Jane", null, null, "456 Elm St"));
        assertEquals("Jane", contactService.getContact("12345").getFirstName());
        assertEquals("456 Elm St", contactService.getContact("12345").getAddress());
        assertFalse(contactService.updateContact("67890", "Jane", null, null, "456 Elm St")); // Non-existent ID
    }

    // Additional tests for edge cases
}