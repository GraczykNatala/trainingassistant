package pl.graczyk.trainingassistant.domain.bodypart;

import org.springframework.stereotype.Service;
import pl.graczyk.trainingassistant.domain.bodypart.dto.BodypartDto;

import java.util.Optional;

@Service
public class BodypartService {
    private final BodypartRepository bodypartRepository;

    public BodypartService(BodypartRepository bodypartRepository) {
        this.bodypartRepository = bodypartRepository;
    }
    public Optional<BodypartDto> findBodypartByName(String name) {
        return bodypartRepository.findByNameIgnoreCase(name)
                .map(BodypartDtoMapper::map);
    }
}
