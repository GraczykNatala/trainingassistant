package pl.graczyk.trainingassistant.domain.bodypart;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BodypartRepository extends CrudRepository<Bodypart, Long> {

    Optional<Bodypart> findByNameIgnoreCase(String name);
}
