package pe.edu.uni.restaurant.gryffindor_center_platform.persona.interfaces.acl;

import org.springframework.stereotype.Service;
import pe.edu.uni.restaurant.gryffindor_center_platform.persona.domain.model.aggregates.User;
import pe.edu.uni.restaurant.gryffindor_center_platform.persona.infrastructure.persistence.jpa.repositories.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserContextFacade {
    private final UserRepository userRepository;

    public UserContextFacade(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<UUID> getUserCodeUser(UUID userCode) {
        return userRepository.findByUserCode(userCode)
                .map(User::getUserCode);
    }
}