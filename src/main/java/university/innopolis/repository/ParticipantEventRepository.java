package university.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import university.innopolis.entity.ParticipantEvent;
import university.innopolis.entity.ParticipantEventId;

import java.util.List;

public interface ParticipantEventRepository extends JpaRepository<ParticipantEvent, ParticipantEventId> {
    List<ParticipantEvent> findByParticipantId(Long participantId);
    List<ParticipantEvent> findByEventId(Long eventId);
    long countByEventId(Long eventId);
}
