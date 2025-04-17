package university.innopolis.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import university.innopolis.dto.EventRequest;
import university.innopolis.dto.EventResponse;
import university.innopolis.dto.ParticipantResponse;
import university.innopolis.entity.Event;
import university.innopolis.entity.Participant;
import university.innopolis.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    public EventResponse create(@RequestBody @Valid EventRequest eventRequest) {
        Event event = eventRequest.toEntity();
        Event saved = service.createEvent(event);
        return EventResponse.fromEntity(saved);
    }

    @GetMapping
    public List<EventResponse> getAll() {
        return service.getAllEvents()
            .stream()
            .map(EventResponse::fromEntity)
            .toList();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEvent(id);
    }

    @GetMapping("/{id}")
    public EventResponse get(@PathVariable Long id) {
        return EventResponse.fromEntity(service.getEvent(id));
    }

    @GetMapping("/{id}/participants")
    public List<ParticipantResponse> getEventParticipants(@PathVariable Long id) {
        List<Participant> participants = service.getParticipants(id);
        return participants.stream()
            .map(ParticipantResponse::fromEntity)
            .toList();
    }
}

