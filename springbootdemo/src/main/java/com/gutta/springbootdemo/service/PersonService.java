package com.gutta.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gutta.springbootdemo.model.Person;
import com.gutta.springbootdemo.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	@Transactional
	public List<Person> getAllPersons() {
		return (List<Person>) personRepository.findAll();
	}

	@Transactional
	public List<Person> findByName(String name) {
		return personRepository.findByFirstName(name);
	}

	@Transactional
	public Optional<Person> getById(Long id) {
		return personRepository.findById(id);
	}

	@Transactional
	public void deletePerson(Long personId) {
		personRepository.deleteById(personId);
	}

	@Transactional
	public boolean addPerson(Person person) {
		return personRepository.save(person) != null;
	}

	@Transactional
	public boolean updatePerson(Person person) {
		return personRepository.save(person) != null;
	}
}
