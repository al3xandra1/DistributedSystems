package gr.hua.dit.ds.ds_lab.Controllers;

import gr.hua.dit.ds.ds_lab.Models.Event;
import gr.hua.dit.ds.ds_lab.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    public String createEvent(@ModelAttribute Event event) {
        eventService.createEvent(event);
        return "redirect:/events"; // Ανακατεύθυνση στην σελίδα όλων των εκδηλώσεων
    }

    @GetMapping("/")
    public String getAllEvents(Model model) {
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "events"; // Όνομα της σελίδας Thymeleaf για τις εκδηλώσεις
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        if (event != null) {
            return new ResponseEntity<>(event, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}/approve")
    public String approveEvent(@PathVariable Long id) {
        Event approvedEvent = eventService.approveEvent(id);
        return "redirect:/events"; // Ανακατεύθυνση μετά την έγκριση
    }

    @PatchMapping("/{id}/reject")
    public String rejectEvent(@PathVariable Long id) {
        Event rejectedEvent = eventService.rejectEvent(id);
        return "redirect:/events"; // Ανακατεύθυνση μετά την απόρριψη
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
