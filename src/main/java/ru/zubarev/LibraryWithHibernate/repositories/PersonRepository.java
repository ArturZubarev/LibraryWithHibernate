package ru.zubarev.LibraryWithHibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zubarev.LibraryWithHibernate.models.Person;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    Optional<Person> findByName(String name);
}
