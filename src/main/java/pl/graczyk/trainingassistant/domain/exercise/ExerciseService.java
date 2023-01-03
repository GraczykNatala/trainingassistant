package pl.graczyk.trainingassistant.domain.exercise;

import org.springframework.stereotype.Service;
import pl.graczyk.trainingassistant.domain.bodypart.Bodypart;
import pl.graczyk.trainingassistant.domain.bodypart.BodypartRepository;
import pl.graczyk.trainingassistant.domain.exercise.dto.ExerciseDto;
import java.util.List;
import java.util.Optional;


@Service

public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final BodypartRepository bodypartRepository;
    public ExerciseService(ExerciseRepository exerciseRepository,
                           BodypartRepository bodypartRepository){
        this.exerciseRepository = exerciseRepository;
        this.bodypartRepository = bodypartRepository;
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
        public void addExercise(ExerciseDto exerciseToSave) {
        Exercise exercise = new Exercise();
        exercise.setName(exerciseToSave.getName());
        exercise.setLevelOfAdvancement(exerciseToSave.getLevelOfAdvancement());
        exercise.setEquipment(exerciseToSave.getEquipment());
         exercise.setDescribtion(exerciseToSave.getDescription());
         exercise.setYoutubeId(exerciseToSave.getYoutubeId());
         exercise.setRecommended(exerciseToSave.isRecommended());
         Bodypart bodypart =
                 bodypartRepository.findByNameIgnoreCase(exerciseToSave.getBodypart()).orElseThrow();
            exercise.setBodypart(bodypart);

            exerciseRepository.save(exercise);
        }
}