package gr.hua.dit.spdemo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private boolean approved;

    @Enumerated(EnumType.STRING) // Αποθήκευση ως String στη βάση δεδομένων
    private EventStatus status;

    // Default Constructor
    public Event(long l, String testEvent, String s, boolean b) {}

    // Constructor
    public Event(Long id, String name, String description, boolean approved, EventStatus status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.approved = approved;
        this.status = status;
    }

    public Event() {
        this.approved = false;
        this.status = EventStatus.PENDING;
    }

    // Getters and Setters
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
}
