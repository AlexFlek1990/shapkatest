package ru.af.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.af.dao.entity.User;
import ru.af.dao.entity.Word;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer> {
    List<Word> findByUserId(long id);
}

