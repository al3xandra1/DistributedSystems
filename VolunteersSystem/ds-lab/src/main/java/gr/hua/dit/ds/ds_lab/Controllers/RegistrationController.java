package gr.hua.dit.ds.ds_lab.Controllers;

import gr.hua.dit.ds.ds_lab.Models.Registration; // Διόρθωση του import
import gr.hua.dit.ds.ds_lab.Service.RegistrationService; // Import της RegistrationService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Προσθήκη annotation για να αναγνωρίζεται ως RestController
@RequestMapping("/registrations") // Κοινό prefix για τα endpoints
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    // Δημιουργία νέας εγγραφής εθελοντή
    @PostMapping("/register")
    public ResponseEntity<Registration> registerVolunteer(@RequestBody Registration registration) {
        Registration createdRegistration = registrationService.registerVolunteer(registration);
        return new ResponseEntity<>(createdRegistration, HttpStatus.CREATED);
    }

    // Επιστροφή εγγραφών για συγκεκριμένο event
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Registration>> getRegistrationsByEvent(@PathVariable Long eventId) {
        List<Registration> registrations = registrationService.getRegistrationsByEvent(eventId);
        return new ResponseEntity<>(registrations, HttpStatus.OK);
    }

    // Έγκριση εγγραφής
    @PatchMapping("/{id}/approve")
    public ResponseEntity<Registration> approveRegistration(@PathVariable Long id) {
        Registration approvedRegistration = registrationService.approveRegistration(id);
        return new ResponseEntity<>(approvedRegistration, HttpStatus.OK);
    }

    // Απόρριψη εγγραφής
    @PatchMapping("/{id}/reject")
    public ResponseEntity<Registration> rejectRegistration(@PathVariable Long id) {
        Registration rejectedRegistration = registrationService.rejectRegistration(id);
        return new ResponseEntity<>(rejectedRegistration, HttpStatus.OK);
    }

    // Διαγραφή εγγραφής
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

