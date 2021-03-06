package br.com.jonathanphilipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jonathanphilipe.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
