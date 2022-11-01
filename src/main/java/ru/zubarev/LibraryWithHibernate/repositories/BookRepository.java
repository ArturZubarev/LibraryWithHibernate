package ru.zubarev.LibraryWithHibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zubarev.LibraryWithHibernate.models.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBookByNameStartingWith(String name);
}
