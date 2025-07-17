package br.ultimate_restfull.repository;

import br.ultimate_restfull.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
