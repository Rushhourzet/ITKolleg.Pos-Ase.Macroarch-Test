package at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.repositories;

import at.itkollegimst.hampl.pos1makro.test2.simple.bookshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Collection<User> getUsersByName(String username);
}
