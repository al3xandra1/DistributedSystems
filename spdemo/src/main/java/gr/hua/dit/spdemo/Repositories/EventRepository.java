package gr.hua.dit.spdemo.Repositories;

import gr.hua.dit.spdemo.Models.Event;
import gr.hua.dit.spdemo.Models.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByOrganizationIdAndStatus(Long organizationId, EventStatus status);
}
