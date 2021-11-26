package com.gutta.springbootdemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.gutta.springbootdemo.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findByFirstName(String firstName);
}
