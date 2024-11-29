package pe.edu.uni.restaurant.gryffindor_center_platform.iam.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.uni.restaurant.gryffindor_center_platform.iam.domain.model.commands.SeedRolesCommand;
import pe.edu.uni.restaurant.gryffindor_center_platform.iam.domain.model.entities.Role;
import pe.edu.uni.restaurant.gryffindor_center_platform.iam.domain.model.valueobjects.Roles;
import pe.edu.uni.restaurant.gryffindor_center_platform.iam.domain.services.RoleCommandService;
import pe.edu.uni.restaurant.gryffindor_center_platform.iam.infrastructure.persistence.jpa.repositories.RoleRepository;

import java.util.Arrays;

/**
 * Implementation of {@link RoleCommandService} to handle {@link SeedRolesCommand}
 */
@Service
public class RoleCommandServiceImpl implements RoleCommandService {

  private final RoleRepository roleRepository;

  public RoleCommandServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  /**
   * This method will handle the {@link SeedRolesCommand} and will create the roles if not exists
   * @param command {@link SeedRolesCommand}
   * @see SeedRolesCommand
   */
  @Override
  public void handle(SeedRolesCommand command) {
    Arrays.stream(Roles.values())
        .forEach(role -> {
          if(!roleRepository.existsByName(role)) {
            roleRepository.save(new Role(Roles.valueOf(role.name())));
          }
        } );
  }
}
