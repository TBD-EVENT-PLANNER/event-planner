package university.innopolis.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import university.innopolis.entity.Event;
import university.innopolis.entity.Participant;
import university.innopolis.entity.ParticipantEvent;
import university.innopolis.entity.ParticipantEventId;
import university.innopolis.repository.EventRepository;
import university.innopolis.repository.ParticipantEventRepository;
import university.innopolis.repository.ParticipantRepository;

@Service
@RequiredArgsConstructor
public class ParticipantService {
    private final ParticipantRepository participantRepo;
    private final ParticipantEventRepository registrationRepo;
    private final EventRepository eventRepo;
    private final EmailService emailService;

    public Participant registerParticipant(Participant p) {
        return participantRepo.save(p);
    }

    public void registerToEvent(Long participantId, Long eventId) {
        var participant = participantRepo.findById(participantId)
            .orElseThrow(() -> new IllegalArgumentException("Participant not found"));

        var event = eventRepo.findById(eventId)
            .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        long currentRegistrations = registrationRepo.countByEventId(eventId);

        if (currentRegistrations >= event.getNumberOfSeats()) {
            throw new IllegalStateException("Cannot register: event is full");
        }

        var registration = new ParticipantEvent();
        registration.setParticipant(participant);
        registration.setEvent(event);
        registrationRepo.save(registration);
    }

    public List<Event> getParticipantEvents(Long id) {
        List<ParticipantEvent> participantEvents = registrationRepo.findByParticipantId(id);
        return participantEvents.stream()
            .map(ParticipantEvent::getEvent)
            .toList();
    }

    public void deleteRegistration(Long participantId, Long eventId) {
        registrationRepo.deleteById(new ParticipantEventId(participantId, eventId));
    }

    public void sendVerificationCode(String email) {
        emailService.sendVerificationCode(email);
    }

    public boolean verifyCode(String email, String code) {
        return emailService.verifyCode(email, code);
    }
}
