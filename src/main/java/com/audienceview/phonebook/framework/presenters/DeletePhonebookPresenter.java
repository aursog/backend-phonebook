package com.audienceview.phonebook.framework.presenters;

import org.springframework.http.ResponseEntity;

public interface DeletePhonebookPresenter {
    ResponseEntity present(Boolean active);
}
