package ru.af.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.af.dao.entity.Team;


public interface TeamRepository extends JpaRepository<Team, Integer> {
    Team findById(Integer id);
}
