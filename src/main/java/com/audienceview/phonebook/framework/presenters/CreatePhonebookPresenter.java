package com.audienceview.phonebook.framework.presenters;

import com.audienceview.phonebook.core.entities.Phonebook;
import org.springframework.http.ResponseEntity;

public interface CreatePhonebookPresenter {
    ResponseEntity present(Phonebook phonebook);
}
