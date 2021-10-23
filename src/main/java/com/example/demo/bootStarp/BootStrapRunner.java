package com.example.demo.bootStarp;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapRunner implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapRunner(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started Spring boot app");

        Publisher publisher=new Publisher();
        publisher.setName("Book publishers");
        publisher.setAddressLine1("kondapeta");
        publisher.setCity("Hyderabad");
        publisher.setState("A.P");
        publisher.setZip("500032");

        publisherRepository.save(publisher);

        System.out.println("Publisher count:: "+ publisherRepository.count());

        Book book1=new Book("20 lessons","432342244");
        Author author1=new Author("yuval","harari");
        book1.getAuthors().add(author1);
        author1.getBooks().add(book1);
        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);
        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher);

        Book book2=new Book("sapiens","12343566777");
        Author author2=new Author("yuval","harari");
        book2.getAuthors().add(author2);
        author2.getBooks().add(book2);
        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);
        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher);

        System.out.println("No of books :: "+ bookRepository.count());
        System.out.println("No of books published by publisher :: "+ publisher.getBooks().size());
    }
}
