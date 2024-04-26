package guru.springframework.spring6webapp.bootstrap;

import java.rmi.server.ExportException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;

@Component
public class BootstrapData  implements CommandLineRunner{

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  
  public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository){
    this.authorRepository = authorRepository;
    this.bookRepository=bookRepository;
  }


  @Override
  public void run(String... args) throws Exception{
    Author eric = new Author();
    eric.setFirstName("Eric");
    eric.setLastName("Langton");

    Book blackTullip = new Book();
    blackTullip.setTitle("Black Tullip");
    blackTullip.setIsbn("324234");

    Author ericSaved = authorRepository.save(eric);
    Book blacktullipSaved = bookRepository.save(blackTullip);


    Author charlotte = new Author();
    charlotte.setFirstName("Charlotte");
    charlotte.setLastName("Bronte");

    Book janeEyere = new Book();
    janeEyere.setTitle("Jane Eyere");
    janeEyere.setIsbn("332324");

    Author charlotteSaved = authorRepository.save(charlotte);
    Book janeEyereSaved = bookRepository.save(janeEyere);

    ericSaved.getBooks().add(blacktullipSaved);
    charlotteSaved.getBooks().add(janeEyereSaved);

    authorRepository.save(ericSaved);
    authorRepository.save(charlotteSaved);

    System.out.println("in bootstrap");
    System.out.println("Author: " + authorRepository.count());
    System.out.println("Books: " + bookRepository.count());

  }

}

/*
Summary
we added the bootstrap data - BootstrapData Implements CommandLineRunner.
We are annotating this with a Component annotation saying that this is a Spring component, so when
Spring looks at the packages, it'll see this and then it will create a Spring bean for it.
Remember Spring Data JPA is giving us the implementations for AuthorRepository and BookRepository.
 */