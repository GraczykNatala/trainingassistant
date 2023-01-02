package pl.graczyk.trainingassistant.domain.user;

import pl.graczyk.trainingassistant.domain.user.dto.UserCredentialsDto;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<UserCredentialsDto> findCredentialsByEmail(String email){
        return userRepository.findByEmail(email)
                .map(UserCredentialsDtoMapper::map);
    }
}
