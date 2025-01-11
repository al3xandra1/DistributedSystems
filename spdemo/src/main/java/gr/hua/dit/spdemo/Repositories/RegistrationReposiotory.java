package gr.hua.dit.spdemo.Repositories;

import gr.hua.dit.spdemo.Models.Registration;
import gr.hua.dit.spdemo.Models.RegistrationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationReposiotory extends JpaRepository<Registration, Long> {
    List<Registration> findByEventIdAndStatus(Long eventId, RegistrationStatus status);
}
