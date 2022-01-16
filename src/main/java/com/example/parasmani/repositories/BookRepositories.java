package com.example.parasmani.repositories;

import com.example.parasmani.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepositories extends CrudRepository<Book, Long> {
}
