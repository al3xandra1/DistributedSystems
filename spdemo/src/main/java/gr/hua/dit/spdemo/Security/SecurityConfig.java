package gr.hua.dit.spdemo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity // Ενεργοποιεί την ασφάλεια για τη χρήση annotations όπως @PreAuthorize
public class SecurityConfig {

    // Ορισμός της κύριας αλυσίδας φίλτρων ασφάλειας
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HttpSecurity logout1 = http
                .authorizeHttpRequests(authorize -> authorize
                        // Επιτρέπεται πρόσβαση μόνο σε χρήστες με ρόλο ADMIN για endpoints που ξεκινούν με /admin/
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        // Επιτρέπεται πρόσβαση μόνο σε χρήστες με ρόλο ORGANIZATION για endpoints που ξεκινούν με /organization/
                        .requestMatchers("/organization/**").hasRole("ORGANIZATION")
                        // Επιτρέπεται πρόσβαση μόνο σε χρήστες με ρόλο VOLUNTEER για endpoints που ξεκινούν με /volunteer/
                        .requestMatchers("/volunteer/**").hasRole("VOLUNTEER")
                        // Επιτρέπεται πρόσβαση σε όλες τις υπόλοιπες σελίδες
                        .anyRequest().permitAll()
                )
                // Ορισμός custom φόρμας εισόδου
                .formLogin(form -> form
                        .loginPage("/login").permitAll() // Όλοι μπορούν να δουν τη σελίδα σύνδεσης
                )
                // Ορισμός συμπεριφοράς κατά την έξοδο
                .logout(logout -> logout
                        .permitAll() // Επιτρέπεται η έξοδος σε όλους
                );

        return http.build(); // Επιστροφή του διαμορφωμένου HttpSecurity αντικειμένου
    }

    // Ορισμός χρηστών με in-memory authentication
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // Δημιουργία χρήστη με ρόλο ADMIN
        UserDetails admin = User.builder()
                .username("admin") // Όνομα χρήστη
                .password(passwordEncoder.encode("adminpassword")) // Κρυπτογραφημένος κωδικός
                .roles("ADMIN") // Ρόλος
                .build();

        // Δημιουργία χρήστη με ρόλο ORGANIZATION
        UserDetails organization = User.builder()
                .username("organization")
                .password(passwordEncoder.encode("organizationpassword"))
                .roles("ORGANIZATION")
                .build();

        // Δημιουργία χρήστη με ρόλο VOLUNTEER
        UserDetails volunteer = User.builder()
                .username("volunteer")
                .password(passwordEncoder.encode("volunteerpassword"))
                .roles("VOLUNTEER")
                .build();

        // Επιστροφή ενός InMemoryUserDetailsManager που περιλαμβάνει τους χρήστες
        return new InMemoryUserDetailsManager(admin, organization, volunteer);
    }

    // Ορισμός του PasswordEncoder για κρυπτογράφηση κωδικών
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Χρησιμοποιεί τον αλγόριθμο BCrypt για ασφάλεια
    }
}
