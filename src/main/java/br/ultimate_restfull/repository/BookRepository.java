package br.ultimate_restfull.repository;

import br.ultimate_restfull.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
