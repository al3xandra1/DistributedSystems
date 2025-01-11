package gr.hua.dit.spdemo.Repositories;

import gr.hua.dit.spdemo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository για τη διαχείριση χρηστών στην εφαρμογή
public interface UserRepository extends JpaRepository<User, Long> {
    // Εύρεση χρήστη με βάση το όνομα χρήστη
    User findByUsername(String username);
}
