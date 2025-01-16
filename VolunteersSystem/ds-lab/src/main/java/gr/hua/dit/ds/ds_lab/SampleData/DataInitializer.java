package gr.hua.dit.ds.ds_lab.SampleData;

import java.util.Set;

import gr.hua.dit.ds.ds_lab.Models.Event;
import gr.hua.dit.ds.ds_lab.Models.Registration;
import gr.hua.dit.ds.ds_lab.Models.Role;
import gr.hua.dit.ds.ds_lab.Models.User;
import gr.hua.dit.ds.ds_lab.Models.EventStatus;
import gr.hua.dit.ds.ds_lab.Models.RegistrationStatus;
import gr.hua.dit.ds.ds_lab.Repositories.EventRepository;
import gr.hua.dit.ds.ds_lab.Repositories.RegistrationRepository;
import gr.hua.dit.ds.ds_lab.Repositories.RoleRepository;
import gr.hua.dit.ds.ds_lab.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RegistrationRepository registrationRepository;


    @Override
    public void run(String... args) {

        // Διαγραφή προηγούμενων δεδομένων από τους πίνακες
        registrationRepository.deleteAll();
        eventRepository.deleteAll();
        userRepository.deleteAll();
        roleRepository.deleteAll();

        // Δημιουργία ρόλων
        Role adminRole = roleRepository.save(new Role(null, "ADMIN")); // ρόλος διαχειριστή
        Role userRole = roleRepository.save(new Role(null, "USER")); // ρόλος χρήστη

        // Δημιουργία χρηστών
        User admin1 = new User(null, "admin", "admin@gmail.com", "adminpass", true, Set.of(adminRole));
        User user1 = new User(null, "john_smith", "john7@gmail.com", "johnpass", true, Set.of(userRole));
        User user2 = new User(null, "jane_dixon", "jane_@yahoo.com", "janepass", true, Set.of(userRole));
        User user3 = new User(null, "alex_miles", "alex@gmail.com", "alexpass", true, Set.of(userRole));
        userRepository.save(admin1);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);


        // Δημιουργία εκδηλώσεων
        Event event1 = new Event("Beach Cleanup", "Cleaning the beach and picking up trash", LocalDate.of(2025, 6, 15), EventStatus.PENDING, 1L);
        Event event2 = new Event("Tree Planting", "Planting trees in the local park", LocalDate.of(2025, 7, 20), EventStatus.PENDING, 2L);
        Event event3 = new Event("Food Drive", "Collecting food for the homeless", LocalDate.of(2025, 8, 10), EventStatus.PENDING, 3L);
        eventRepository.save(event1);
        eventRepository.save(event2);
        eventRepository.save(event3);

        // Δημιουργία εγγραφών εθελοντών
        Registration reg1 = new Registration(null, event1, "Max Stone", "max.stone@gmail.com", RegistrationStatus.PENDING);
        Registration reg2 = new Registration(null, event1, "Kate Nolan", "kate22@gmail.com", RegistrationStatus.APPROVED);
        Registration reg3 = new Registration(null, event2, "Sam Brown", "s.brown@yahoo.com", RegistrationStatus.PENDING);
        Registration reg4 = new Registration(null, event3, "Emily White", "emilyy@gmail.com", RegistrationStatus.REJECTED);
        registrationRepository.save(reg1);
        registrationRepository.save(reg2);
        registrationRepository.save(reg3);
        registrationRepository.save(reg4);
    }

}


