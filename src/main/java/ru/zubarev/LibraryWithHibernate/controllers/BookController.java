package ru.zubarev.LibraryWithHibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.zubarev.LibraryWithHibernate.services.BookService;
import ru.zubarev.LibraryWithHibernate.services.PesronService;

@Controller
@Component
public class BookController {
    private final PesronService pesronService;
    private final BookService bookService;

    @Autowired
    public BookController(PesronService pesronService, BookService bookService) {
        this.pesronService = pesronService;
        this.bookService = bookService;
    }

    @GetMapping()
    public String index(Model model, @RequestParam(value = "page", required = false) Integer page,
                        @RequestParam(value = "books_per_page", required = false) Integer booksPerPage,
                        @RequestParam(value = "sort_by_year",required = false) boolean sortByYear){
        if (page==null||booksPerPage==null)
            model.addAttribute("books",bookService.findAllBooks(sortByYear));
            else
                model.addAttribute("books",bookService.findByPagination(page,booksPerPage,sortByYear));
            return "books/index";
    }

}
