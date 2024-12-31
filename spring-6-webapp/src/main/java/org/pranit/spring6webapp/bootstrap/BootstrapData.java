package org.pranit.spring6webapp.bootstrap;

import org.pranit.spring6webapp.domain.Author;
import org.pranit.spring6webapp.domain.Book;
import org.pranit.spring6webapp.repositories.AuthorRepository;
import org.pranit.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ds = new Book();
        ds.setTitle("Data Structures and Algorithms");
        ds.setIsbn("33432");

        Author ericSaved = authorRepository.save(eric);
        Book dsSaved = bookRepository.save(ds);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book python = new Book();
        python.setTitle("Python Programming");
        python.setIsbn("4343343");

        Author rodSaved = authorRepository.save(rod);
        Book pythonSaved = bookRepository.save(python);

        ericSaved.getBooks().add(dsSaved);
        rodSaved.getBooks().add(pythonSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In bootstrap");
        System.out.println("Author count:: " + authorRepository.count());
        System.out.println("Book count:: "+ bookRepository.count());
    }
}
