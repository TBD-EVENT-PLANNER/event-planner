package university.innopolis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(ParticipantEventId.class)
@Table(name = "participant_event")
public class ParticipantEvent implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "participant_id", nullable = false)
    private Participant participant;

    @Id
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    public ParticipantEvent() {
    }

    public ParticipantEvent(Participant participant, Event event) {
        this.participant = participant;
        this.event = event;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ParticipantEvent that)) {
            return false;
        }
        return Objects.equals(participant, that.participant) &&
               Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participant, event);
    }

    @Override
    public String toString() {
        return "ParticipantEvent{" +
               "participant=" + participant +
               ", event=" + event +
               '}';
    }
}
