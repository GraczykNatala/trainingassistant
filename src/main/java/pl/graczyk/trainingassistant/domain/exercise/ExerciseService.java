package pl.graczyk.trainingassistant.domain.exercise;

import org.springframework.stereotype.Service;
import pl.graczyk.trainingassistant.domain.exercise.dto.ExerciseDto;

import java.util.List;

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
}