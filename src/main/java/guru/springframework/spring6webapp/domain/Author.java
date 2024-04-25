package guru.springframework.spring6webapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

// if we use jakarta persistence, 
// this is what is telling JPA that is going to be an entity persisted to the database

@Entity 
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String firstName;
  private String lastName;

  // we are going to use annotation ManyToMany, meaning that we have have authors to many books
  @ManyToMany(mappedBy = "authors")
  private Set<Book> books;

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }




  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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
  public String toString() {
    return "Author{" +
            "id=" + id + 
            ",  firstName = ' " + '\'' +
            ",  lastName = ' " + '\'' +
            ",  books = " + books +
            '}';

  }

  
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
