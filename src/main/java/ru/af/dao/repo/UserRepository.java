package ru.af.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.af.dao.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
}
