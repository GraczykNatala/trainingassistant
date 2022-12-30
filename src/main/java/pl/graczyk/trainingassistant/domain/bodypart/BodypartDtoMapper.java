package pl.graczyk.trainingassistant.domain.bodypart;

import pl.graczyk.trainingassistant.domain.bodypart.dto.BodypartDto;

public class BodypartDtoMapper {

    static BodypartDto map(Bodypart bodypart){
        return new BodypartDto(
                bodypart.getId(),
                bodypart.getName(),
                bodypart.getDescribtion()
                );
    }
}
