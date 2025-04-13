//package university.innopolis.controller;
//
//import university.innopolis.entity.Participant;
//import university.innopolis.repository.ParticipantEventRepository;
//import university.innopolis.service.ParticipantService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/participants")
//public class ParticipantController {
//    private final ParticipantService service;
//
//    public ParticipantController(ParticipantService service) {
//        this.service = service;
//    }
//
//    @PostMapping
//    public Participant register(@RequestBody Participant p) {
//        return service.registerParticipant(p);
//    }
//
//    @PostMapping("/{participantId}/register/{eventId}")
//    public void registerToEvent(@PathVariable Long participantId, @PathVariable Long eventId) {
//        service.registerToEvent(participantId, eventId);
//    }
//
//    @GetMapping("/{participantId}/events")
//    public List<ParticipantEventRepository> getEvents(@PathVariable Long participantId) {
//        return service.getParticipantEvents(participantId);
//    }
//
//    @DeleteMapping("/{participantId}/unregister/{eventId}")
//    public void unregister(@PathVariable Long participantId, @PathVariable Long eventId) {
//        service.deleteRegistration(participantId, eventId);
//    }
//}
