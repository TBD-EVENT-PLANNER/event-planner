package university.innopolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import university.innopolis.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
