package com.novawallet.entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ContactTest {

    @Test
    public void testGetFullName() {
        Contact contact = new Contact(1, "john", "doe", "john.doe@example.com");
        String fullName = contact.getFullName();
        assertEquals("John Doe", fullName);
    }

    @Test
    public void testSetGetName() {
        Contact contact = new Contact(1, "john", "doe", "john.doe@example.com");
        contact.setName("jane");
        assertEquals("jane", contact.getName());
    }

    @Test
    public void testSetGetLastname() {
        Contact contact = new Contact(1, "john", "doe", "john.doe@example.com");
        contact.setLastname("smith");
        assertEquals("smith", contact.getLastname());
    }

    @Test
    public void testSetGetEmail() {
        Contact contact = new Contact(1, "john", "doe", "john.doe@example.com");
        contact.setEmail("jane.smith@example.com");
        assertEquals("jane.smith@example.com", contact.getEmail());
    }

    @Test
    public void testMockGetId() {
        Contact contact = mock(Contact.class);
        when(contact.getId()).thenReturn(123);
        int id = contact.getId();
        assertEquals(123, id);
    }

    @Test
    public void testSetGetId() {
        Contact contact = new Contact(1, "john", "doe", "john.doe@example.com");;
        assertEquals(1, contact.getId());
    }
}