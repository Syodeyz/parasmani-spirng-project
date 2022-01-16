package com.example.parasmani.repositories;

import com.example.parasmani.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepositories extends CrudRepository<Author, Long> {
}
