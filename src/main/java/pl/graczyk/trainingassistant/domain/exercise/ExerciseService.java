package pl.graczyk.trainingassistant.domain.exercise;

import org.springframework.stereotype.Service;
import pl.graczyk.trainingassistant.domain.bodypart.dto.BodypartDto;
import pl.graczyk.trainingassistant.domain.exercise.dto.ExerciseDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service

public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    public ExerciseService(ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
    }
    public List<ExerciseDto> findAllRecommended() {
        return exerciseRepository.findAllByRecommendedIsTrue().stream()
                .map(ExerciseDtoMapper::map)
                .toList();
    }
    public Optional<ExerciseDto> findExerciseById(long id) {
        return exerciseRepository.findById(id).map(ExerciseDtoMapper::map);
    }
    public List<ExerciseDto> findExercisesByBodypart(String bodybpart){
        return exerciseRepository.findAllByBodypart_NameIgnoreCase(bodybpart)
                .stream()
                .map(ExerciseDtoMapper::map)
                .toList();
    }

}