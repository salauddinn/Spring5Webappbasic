package com.example.demo.repository;

import com.example.demo.domain.*;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
