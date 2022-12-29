package pl.graczyk.trainingassistant.domain.exercise;

import pl.graczyk.trainingassistant.domain.exercise.dto.ExerciseDto;

public class ExerciseDtoMapper {
    static ExerciseDto map(Exercise exercise){
        return new ExerciseDto(
                exercise.getId(),
                exercise.getName(),
                exercise.getLevelOfAdvancement(),
                exercise.getEquipment(),
                exercise.getDescribtion(),
                exercise.getYoutubeId(),
                exercise.getBodypart().getName(),
                exercise.isRecommended()


        );
    }
}
