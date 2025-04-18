package university.innopolis.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import university.innopolis.dto.EventResponse;
import university.innopolis.dto.ParticipantRequest;
import university.innopolis.dto.ParticipantResponse;
import university.innopolis.entity.Participant;
import university.innopolis.service.ParticipantService;

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
    public List<EventResponse> getEvents(@PathVariable Long participantId) {
        var events = service.getParticipantEvents(participantId);
        return events.stream()
                .map(EventResponse::fromEntity)
                .toList();
    }

    @DeleteMapping("/{participantId}/unregister/{eventId}")
    public void unregister(@PathVariable Long participantId, @PathVariable Long eventId) {
        service.deleteRegistration(participantId, eventId);
    }

    @PostMapping("/send-code")
    public ResponseEntity<Void> sendVerificationCode(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        service.sendVerificationCode(email);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/verify-code")
    public ResponseEntity<Map<String, Boolean>> verifyCode(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String code = payload.get("code");
        boolean success = service.verifyCode(email, code);
        return ResponseEntity.ok(Map.of("success", success));
    }
}
