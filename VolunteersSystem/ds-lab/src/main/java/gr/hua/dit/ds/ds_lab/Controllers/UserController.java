package gr.hua.dit.ds.ds_lab.Controllers;
import gr.hua.dit.ds.ds_lab.Models.User;
import gr.hua.dit.ds.ds_lab.Models.LoginRequest;
import gr.hua.dit.ds.ds_lab.Service.UserService;
import gr.hua.dit.ds.ds_lab.Models.User;
import gr.hua.dit.ds.ds_lab.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") // Βασική διαδρομή για τις λειτουργίες χρηστών
public class UserController {

    @Autowired
    private UserService userService; // Υπηρεσία για τη διαχείριση χρηστών

    // Καταχώρηση νέου χρήστη
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        // Δημιουργία του χρήστη και επιστροφή του με κατάσταση HTTP CREATED
        User createUser = userService.registerUser(user);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    // Σύνδεση χρήστη
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        // Έλεγχος των στοιχείων σύνδεσης και επιστροφή ενός token
        String token = userService.authenticateUser(loginRequest);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    // Εύρεση χρήστη με βάση το ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        // Αναζήτηση του χρήστη από τη βάση δεδομένων και επιστροφή του
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Ενημέρωση στοιχείων χρήστη
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        // Ενημέρωση του χρήστη με βάση τα νέα δεδομένα
        User updateUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    // Διαγραφή χρήστη
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        // Διαγραφή του χρήστη από τη βάση δεδομένων
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
