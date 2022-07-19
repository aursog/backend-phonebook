package com.audienceview.phonebook.framework.presenters.impl;

import com.audienceview.phonebook.core.entities.Phonebook;
import com.audienceview.phonebook.framework.behavior.output.PhonebookOutDTO;
import com.audienceview.phonebook.framework.presenters.ListPhonebookPresenter;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ListPhonebookPresenterImpl implements ListPhonebookPresenter {

    @Override
    public ResponseEntity present(List<Phonebook> phonebookList) {
        return ResponseEntity.ok().body(phonebookList.stream().map(phonebook -> PhonebookOutDTO.builder()
                .id(phonebook.getId()).fullname(phonebook.getFullname()).phonenumber(phonebook.getPhone()).build()
        ));
    }
}
