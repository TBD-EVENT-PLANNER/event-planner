package university.innopolis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import java.util.Objects;
import lombok.Getter;

@Getter @Entity
@Table(name = "event")
public class Event {
    // Getters and setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String eventType;

    private ZonedDateTime eventDateTime;

    private int numberOfSeats;

//    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<ParticipantEvent> participantEvents = new HashSet<>();

    // Constructors
    public Event() {
    }

    public Event(String title, String eventType, ZonedDateTime eventDateTime, int numberOfSeats) {
        this.title = title;
        this.eventType = eventType;
        this.eventDateTime = eventDateTime;
        this.numberOfSeats = numberOfSeats;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setEventDateTime(ZonedDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

//    public Set<ParticipantEvent> getParticipantEvents() {
//        return participantEvents;
//    }
//
//    public void setParticipantEvents(Set<ParticipantEvent> participantEvents) {
//        this.participantEvents = participantEvents;
//    }

    // equals and hashCode (for Hibernate & Set handling)
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Event event)) {
            return false;
        }
        return Objects.equals(id, event.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", title='" + title
               + '\'' + ", eventType='" + eventType + '\'' + ", eventDateTime="
               + eventDateTime + ", numberOfSeats=" + numberOfSeats + '}';
    }
}
