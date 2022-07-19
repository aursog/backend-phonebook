package com.audienceview.phonebook.datasources.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.audienceview.phonebook.datasources.jpas.PhonebookJPA;

@Repository
public interface PhonebookDAO extends CrudRepository<PhonebookJPA, Long> {
}
