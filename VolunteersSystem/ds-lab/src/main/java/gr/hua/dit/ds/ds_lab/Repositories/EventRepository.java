package gr.hua.dit.ds.ds_lab.Repositories;

import gr.hua.dit.ds.ds_lab.Models.Event;
import gr.hua.dit.ds.ds_lab.Models.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByOrganizationIdAndStatus(Long organizationId, EventStatus status);
}

