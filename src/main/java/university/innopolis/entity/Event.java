package university.innopolis.entity;


import jakarta.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String eventType;
    private ZonedDateTime eventDateTime;
    private int numberOfSeats;

//    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
//    private Set<university.innopolis.entity.ParticipantEventRepository> participants;

    // Getters and setters
}
