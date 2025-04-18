package university.innopolis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String eventType;

    private LocalDateTime eventDateTime;

    private int numberOfSeats;

//    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<ParticipantEvent> participantEvents = new HashSet<>();

    // Constructors
    public Event() {
    }

    public Event(String title, String eventType, LocalDateTime eventDateTime, int numberOfSeats) {
        this.title = title;
        this.eventType = eventType;
        this.eventDateTime = eventDateTime;
        this.numberOfSeats = numberOfSeats;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
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
        if (!(o instanceof Event)) {
            return false;
        }
        Event event = (Event) o;
        return Objects.equals(id, event.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @SuppressWarnings("checkstyle:OperatorWrap") @Override
    public String toString() {
        return "Event{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", eventType='" + eventType + '\'' +
            ", eventDateTime=" + eventDateTime +
            ", numberOfSeats=" + numberOfSeats +
            '}';
    }
}
