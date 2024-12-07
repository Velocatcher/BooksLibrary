
package project.booksLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import project.booksLibrary.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}
