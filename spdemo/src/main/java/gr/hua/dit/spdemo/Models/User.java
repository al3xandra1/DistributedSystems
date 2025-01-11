package gr.hua.dit.spdemo.Models;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Αυτόματη δημιουργία του id
    private Long id;
    @Column(nullable = false, unique = true) // Υποχρεωτικό και μοναδικό
    private String username;
    @Column(nullable = false, unique = true) // Υποχρεωτικό και μοναδικό
    private String email;
    @Column(nullable = false) // Υποχρεωτικό
    private String password;

    // Getters and Setters
    //Επιστρέφει το μοναδικό αναγνωριστικό του χρήστη
    public Long getId() {
        return id;
    }
    //Ορίζει το μοναδικό αναγνωριστικό του χρήστη
    public void setId(Long id) {
        this.id = id;
    }
    //Επιστρέφει το όνομα χρήστη
    public String getUsername() {
        return username;
    }
    //Ορίζει το όνομα χρήστη
    public void setUsername(String username) {
        this.username = username;
    }
    //Επιστρέφει το email του χρήστη
    public String getEmail() {
        return email;
    }
    // Ορίζει το email του χρήστη
    public void setEmail(String email) {
        this.email = email;
    }
    //Επιστρέφει τον κωδικό πρόσβασης του χρήστη
    public String getPassword() {
        return password;
    }
    //Ορίζει τον κωδικό πρόσβασης του χρήστη
    public void setPassword(String password) {
        this.password = password;
    }
}
