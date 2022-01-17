package com.example.parasmani.bootstrap;

import com.example.parasmani.domain.Author;
import com.example.parasmani.domain.Book;
import com.example.parasmani.domain.Publisher;
import com.example.parasmani.repositories.AuthorRepositories;
import com.example.parasmani.repositories.BookRepositories;
import com.example.parasmani.repositories.PublisherRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepositories authorRepositories;
    private final BookRepositories bookRepositories;
    private final PublisherRepositories publisherRepositories;

    public BootStrapData(AuthorRepositories authorRepositories, BookRepositories bookRepositories, PublisherRepositories publisherRepositories) {
        this.authorRepositories = authorRepositories;
        this.bookRepositories = bookRepositories;
        this.publisherRepositories = publisherRepositories;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book book = new Book("Domain driven Design ", "123123");
        Publisher liverbox = new Publisher("LiberBox", "Canda, Torronto");

        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        liverbox.getBooks().add(book);

        authorRepositories.save(eric);
        bookRepositories.save(book);
        publisherRepositories.save(liverbox);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without JEB", "234343");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        liverbox.getBooks().add(noEJB);

        authorRepositories.save(rod);
        bookRepositories.save(noEJB);
        publisherRepositories.save(liverbox);




        System.out.println("Started in BootStrap");
        System.out.println("Number of Books count : " + bookRepositories.count());
        System.out.println("Number of publisher : " + publisherRepositories.count());
        System.out.println("Number of books for LiverBox : " + liverbox.getBooks().size());

    }
}
