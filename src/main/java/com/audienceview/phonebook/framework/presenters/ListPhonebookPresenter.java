package com.audienceview.phonebook.framework.presenters;

import com.audienceview.phonebook.core.entities.Phonebook;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ListPhonebookPresenter {
    ResponseEntity present(List<Phonebook> phonebookList);
}
