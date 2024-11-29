package pe.edu.uni.restaurant.gryffindor_center_platform.iam.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.uni.restaurant.gryffindor_center_platform.iam.domain.model.aggregates.User;

import java.util.Optional;

/**
 * This interface is responsible for providing the TestingUser entity related operations.
 * It extends the JpaRepository interface.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
  /**
   * This method is responsible for finding the user by id.
   * @param id The id of the user.
   * @return The user object.
   */
  Optional<User> findUserById(long id);
  /**
   * This method is responsible for finding the user by username.
   * @param username The username.
   * @return The user object.
   */

  Optional<User> findByUsername(String username);

  /**
   * This method is responsible for checking if the user exists by username.
   * @param username The username.
   * @return True if the user exists, false otherwise.
   */
  boolean existsByUsername(String username);
}
