package com.novawallet.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test the type Contact.
 */
public class ContactTest {

    /**
     * The Contact.
     */
    Contact contact;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        contact = new Contact(1, "john", "doe", "john.doe@example.com");
    }

    /**
     * Test get full name.
     */
    @Test
    public void testGetFullName() {
        String fullName = contact.getFullName();
        assertEquals("John Doe", fullName);
    }

    /**
     * Test set and get name.
     */
    @Test
    public void testSetGetName() {
        contact.setName("jane");
        assertEquals("jane", contact.getName());
    }

    /**
     * Test set and get lastname.
     */
    @Test
    public void testSetGetLastname() {
        contact.setLastname("smith");
        assertEquals("smith", contact.getLastname());
    }

    /**
     * Test set and get email.
     */
    @Test
    public void testSetGetEmail() {
        contact.setEmail("jane.smith@example.com");
        assertEquals("jane.smith@example.com", contact.getEmail());
    }

    /**
     * Test get id with mock.
     */
    @Test
    public void testMockGetId() {
        Contact contact = mock(Contact.class);
        when(contact.getId()).thenReturn(123);
        int id = contact.getId();
        assertEquals(123, id);
    }

    /**
     * Test get id.
     */
    @Test
    public void testGetId() {
        assertEquals(1, contact.getId());
    }
}