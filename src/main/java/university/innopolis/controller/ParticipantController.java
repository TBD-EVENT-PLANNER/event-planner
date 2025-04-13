package university.innopolis.controller;

import jakarta.validation.Valid;
import university.innopolis.dto.ParticipantRequest;
import university.innopolis.dto.ParticipantResponse;
import university.innopolis.entity.Participant;
import university.innopolis.entity.ParticipantEvent;
import university.innopolis.service.ParticipantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {
    private final ParticipantService service;

    public ParticipantController(ParticipantService service) {
        this.service = service;
    }

    @PostMapping
    public ParticipantResponse register(@RequestBody @Valid ParticipantRequest participantRequest) {
        Participant participant = participantRequest.toEntity();
        Participant saved = service.registerParticipant(participant);
        return ParticipantResponse.fromEntity(saved);
    }

    @PostMapping("/{participantId}/register/{eventId}")
    public void registerToEvent(@PathVariable Long participantId, @PathVariable Long eventId) {
        service.registerToEvent(participantId, eventId);
    }

    @GetMapping("/{participantId}/events")
    public List<ParticipantEvent> getEvents(@PathVariable Long participantId) {
        return service.getParticipantEvents(participantId);
    }

    @DeleteMapping("/{participantId}/unregister/{eventId}")
    public void unregister(@PathVariable Long participantId, @PathVariable Long eventId) {
        service.deleteRegistration(participantId, eventId);
    }
}
