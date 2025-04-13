//package university.innopolis.service;
//
//import org.springframework.stereotype.Service;
//import university.innopolis.entity.*;
//import university.innopolis.entity.ParticipantEventRepository;
//import university.innopolis.repository.*;
//
//import java.util.List;
//
//@Service
//public class ParticipantService {
//    private final ParticipantRepository participantRepo;
//    private final ParticipantEventRepository registrationRepo;
//    private final EventRepository eventRepo;
//
//    public ParticipantService(ParticipantRepository participantRepo, ParticipantEventRepository registrationRepo, EventRepository eventRepo) {
//        this.participantRepo = participantRepo;
//        this.registrationRepo = registrationRepo;
//        this.eventRepo = eventRepo;
//    }
//
//    public Participant registerParticipant(Participant p) {
//        return participantRepo.save(p);
//    }
//
//    public void registerToEvent(Long participantId, Long eventId) {
//        var participant = participantRepo.findById(participantId).orElseThrow();
//        var event = eventRepo.findById(eventId).orElseThrow();
//        var reg = new ParticipantEventRepository();
//        reg.setParticipant(participant);
//        reg.setEvent(event);
//        registrationRepo.save(reg);
//    }
//
//    public List<ParticipantEventRepository> getParticipantEvents(Long participantId) {
//        return registrationRepo.findByParticipantId(participantId);
//    }
//
//    public void deleteRegistration(Long participantId, Long eventId) {
//        registrationRepo.deleteById(new ParticipantEventId(participantId, eventId));
//    }
//}
