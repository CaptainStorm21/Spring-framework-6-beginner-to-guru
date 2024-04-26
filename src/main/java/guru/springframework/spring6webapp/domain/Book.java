package guru.springframework.spring6webapp.domain;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import java.util.Objects;


@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  private Long id;
  private String title;
  private String isbn;

  @ManyToAny
  @JoinTable (name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))

  private Set<Author> authors = new HashSet<>();

  public Set<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn() {
    return this.isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
  


  /*
   * This code is implementing the equals() and hashCode() methods typically used
   * for object comparison and hashing in Java.
   * 
   * The equals() method checks if two objects are equal based on their contents
   * rather than their references. In this case, it checks if the objects are the
   * same reference (this == o) or if the object being compared (o) is an instance
   * of the Author class and has the same ID.
   * 
   * The hashCode() method returns a hash code value for the object, which is used
   * by hash-based data structures like HashMap. In this case, it uses the ID of
   * the Author object to generate the hash code.
   * 
   * Position your cursor inside the class where you want to generate the methods.
   * Press Ctrl+Shift+P to open the command palette.
   * Type "Generate equals and hashCode methods" and select the corresponding
   * command
   * 
   */
 

  @Override
  public boolean equals(Object o){
    if (this == o ) return true;
    if(!(o instanceof Author)) return false;

    Author author = (Author) o;

    return getId() !=null ? getId().equals(author.getId()) : author.getId() == null;
   }

   @Override
   public int hashCode(){
    return getId() != null ? getId().hashCode() : 0;
   }
}


