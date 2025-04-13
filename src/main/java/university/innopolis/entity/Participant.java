package university.innopolis.entity;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
    private Set<ParticipantEvent> events;

    public Participant(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Participant() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ParticipantEvent> getEvents() {
        return events;
    }

    public void setEvents(Set<ParticipantEvent> events) {
        this.events = events;
    }
}
