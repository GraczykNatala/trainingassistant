package pl.graczyk.trainingassistant.domain.bodypart;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.graczyk.trainingassistant.domain.bodypart.dto.BodypartDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

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
    public List<BodypartDto> findAllBodyparts(){
        return StreamSupport.stream(bodypartRepository.findAll()
                .spliterator(),false)
                .map(BodypartDtoMapper::map)
                .toList();
    }
    @Transactional
    public void addBodypart(BodypartDto bodypart){
        Bodypart bodypartToSave = new Bodypart();
        bodypartToSave.setName(bodypart.getName());
        bodypartToSave.setDescribtion(bodypart.getDescribtion());
        bodypartRepository.save(bodypartToSave);
    }
}
