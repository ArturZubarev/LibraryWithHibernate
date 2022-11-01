package ru.zubarev.LibraryWithHibernate.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.zubarev.LibraryWithHibernate.models.Person;
import ru.zubarev.LibraryWithHibernate.services.PesronService;

@Component
public class PersonValidator implements Validator {
    private final PesronService pesronService;
    @Autowired
    public PersonValidator(PesronService pesronService) {
        this.pesronService = pesronService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    Person person=(Person) target;
    if (pesronService.getPersonByName(person.getName()).
            isPresent())errors.rejectValue("name", " ","Человек с таким именем не существует");

    }
}
