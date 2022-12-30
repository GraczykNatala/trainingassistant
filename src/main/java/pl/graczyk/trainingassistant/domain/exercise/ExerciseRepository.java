package pl.graczyk.trainingassistant.domain.exercise;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
    List<Exercise> findAllByRecommendedIsTrue();
    List<Exercise> findAllByBodypart_NameIgnoreCase(String bodypart);
}
