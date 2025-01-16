package gr.hua.dit.ds.ds_lab.Models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Κλάση για δοκιμές της κλάσης Event.
// Περιλαμβάνει unit tests για να επαληθευτεί η λειτουργικότητα των getters, setters και του constructor.
class EventTest {

    // Τεστ για τις μεθόδους getId και setId.
    // Επαληθεύει ότι το ID αποθηκεύεται και ανακτάται σωστά.
    @Test
    void testGetAndSetId() {
        Event event = new Event(1L, "Test Event", "This is a test description.", true, EventStatus.PENDING, 100L);
        event.setId(1L);
        assertEquals(1L, event.getId(), "Το ID πρέπει να είναι 1.");
    }

    // Τεστ για τις μεθόδους getName και setName.
    // Επαληθεύει ότι το όνομα αποθηκεύεται και ανακτάται σωστά.
    @Test
    void testGetAndSetName() {
        Event event = new Event(1L, "Test Event", "This is a test description.", true, EventStatus.PENDING, 100L);
        event.setName("Test Event");
        assertEquals("Test Event", event.getName(), "Το όνομα πρέπει να είναι 'Test Event'.");
    }

    // Τεστ για τις μεθόδους getDescription και setDescription.
    // Επαληθεύει ότι η περιγραφή αποθηκεύεται και ανακτάται σωστά.
    @Test
    void testGetAndSetDescription() {
        Event event = new Event(1L, "Test Event", "This is a test description.", true, EventStatus.PENDING, 100L);
        event.setDescription("This is a test description.");
        assertEquals("This is a test description.", event.getDescription(), "Η περιγραφή πρέπει να είναι 'This is a test description.'.");
    }

    // Τεστ για τις μεθόδους isApproved και setApproved.
    // Επαληθεύει ότι το πεδίο έγκρισης αποθηκεύεται και ανακτάται σωστά.
    @Test
    void testIsAndSetApproved() {
        Event event = new Event(1L, "Test Event", "This is a test description.", true, EventStatus.PENDING, 100L);
        event.setApproved(true);
        assertTrue(event.isApproved(), "Η έγκριση πρέπει να είναι true.");
        event.setApproved(false);
        assertFalse(event.isApproved(), "Η έγκριση πρέπει να είναι false.");
    }

    // Τεστ για τη μέθοδο setStatus.
    // Επαληθεύει ότι η κατάσταση αποθηκεύεται και ανακτάται σωστά.
    @Test
    void testEventStatus() {
        Event event = new Event(1L, "Test Event", "This is a test description.", true, EventStatus.PENDING, 100L);
        event.setStatus(EventStatus.APPROVED);
        assertEquals(EventStatus.APPROVED, event.getStatus(), "Η κατάσταση πρέπει να είναι 'APPROVED'.");
    }

    // Τεστ για τον constructor.
    // Επαληθεύει ότι ο constructor αρχικοποιεί σωστά τα πεδία.
    @Test
    void testConstructor() {
        Event event = new Event(1L, "Test Event", "This is a test description.", true, EventStatus.PENDING, 100L);
        assertEquals(1L, event.getId(), "Το ID πρέπει να είναι 1.");
        assertEquals("Test Event", event.getName(), "Το όνομα πρέπει να είναι 'Test Event'.");
        assertEquals("This is a test description.", event.getDescription(), "Η περιγραφή πρέπει να είναι 'This is a test description.'.");
        assertTrue(event.isApproved(), "Η έγκριση πρέπει να είναι true.");
        assertEquals(100L, event.getOrganizationId(), "Το organizationId πρέπει να είναι 100.");
    }
}



