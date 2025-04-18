package university.innopolis.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import university.innopolis.entity.ParticipantEvent;
import university.innopolis.entity.ParticipantEventId;

public interface ParticipantEventRepository extends JpaRepository<ParticipantEvent, ParticipantEventId> {
    List<ParticipantEvent> findByParticipantId(Long participantId);

    List<ParticipantEvent> findByEventId(Long eventId);

    long countByEventId(Long eventId);
}
