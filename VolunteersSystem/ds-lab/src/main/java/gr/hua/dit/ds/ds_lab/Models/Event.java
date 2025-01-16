package gr.hua.dit.ds.ds_lab.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

import java.time.LocalDate;


@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private boolean approved;

    @Enumerated(EnumType.STRING)
    private EventStatus status;
    private Long organizationId;

    private LocalDate eventDate;

    // Constructor με όλες τις παραμέτρους
    public Event(Long id, String name, String description, boolean approved, EventStatus status, Long organizationId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.approved = approved;
        this.status = status;
        this.organizationId = organizationId;

    }

    public Event(String name, String description, LocalDate date, EventStatus status, Long organizationId) {
        this.name = name;
        this.description = description;
        this.approved = false; // Αρχική τιμή για approved
        this.status = status;  // Κατάσταση εκδήλωσης
        this.organizationId = organizationId;
        this.eventDate = date;
    }


    // Constructor χωρίς παραμέτρους για τη δημιουργία κενής εκδήλωσης
    public Event() {
        this.approved = false;
        this.status = EventStatus.PENDING;
    }


    // Getters και Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public Long getOrganizationId() { return organizationId; }

    public void setOrganizationId(Long organizationId) { this.organizationId = organizationId; }

}
