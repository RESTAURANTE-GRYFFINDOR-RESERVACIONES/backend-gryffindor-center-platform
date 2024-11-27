package pe.edu.uni.restaurant.gryffindor_center_platform.persona.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.edu.uni.restaurant.gryffindor_center_platform.persona.domain.model.aggregates.User;
import pe.edu.uni.restaurant.gryffindor_center_platform.persona.domain.model.queries.GetUserByIdQuery;
import pe.edu.uni.restaurant.gryffindor_center_platform.persona.domain.model.queries.GetUserByUUIDQuery;
import pe.edu.uni.restaurant.gryffindor_center_platform.persona.domain.services.UserQueryService;
import pe.edu.uni.restaurant.gryffindor_center_platform.persona.infrastructure.persistence.jpa.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetUserByUUIDQuery query) {
        return this.userRepository.findByUserCodeUser(query.userCode());
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return this.userRepository.findById(query.id());
    }
}