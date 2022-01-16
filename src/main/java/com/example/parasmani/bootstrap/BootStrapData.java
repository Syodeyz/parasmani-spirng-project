package com.example.parasmani.bootstrap;

import com.example.parasmani.domain.Author;
import com.example.parasmani.domain.Book;
import com.example.parasmani.repositories.AuthorRepositories;
import com.example.parasmani.repositories.BookRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepositories authorRepositories;
    private final BookRepositories bookRepositories;

    public BootStrapData(AuthorRepositories authorRepositories, BookRepositories bookRepositories) {
        this.authorRepositories = authorRepositories;
        this.bookRepositories = bookRepositories;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain driven Design ", "123123");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepositories.save(eric);
        bookRepositories.save(book);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without JEB", "234343");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepositories.save(rod);
        bookRepositories.save(noEJB);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books count : " + bookRepositories.count());

    }
}
