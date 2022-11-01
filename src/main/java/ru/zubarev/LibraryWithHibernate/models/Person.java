package ru.zubarev.LibraryWithHibernate.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import java.util.List;
@Entity
@Table(name = "person")
@Component
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private int id;
    @Column(name="name")
    @Size(min = 2,max = 100,message =
    "Значение по полю должно составлять от 2 до 100 символов")
    @NotEmpty
    private String name;
    @Min(value = 1900, message =
    "Год рождения не ранее 1900")
    @Column(name="year_of_birth")
    private int yearOfBirth;
    @OneToMany(mappedBy = "reader")
    private List<Book> books;
    public Person(){}

    public Person(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
