package com.audienceview.phonebook.framework.presenters.impl;

import com.audienceview.phonebook.core.entities.Phonebook;
import com.audienceview.phonebook.framework.behavior.output.CreationObjectDTO;
import com.audienceview.phonebook.framework.presenters.CreatePhonebookPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class CreatePhonebookPresenterImpl implements CreatePhonebookPresenter {

    @Override
    public ResponseEntity<CreationObjectDTO> present(Phonebook phonebook) {
        URI uri = ServletUriComponentsBuilder.fromUriString("/phonebook/get/{id}").buildAndExpand(phonebook.getId()).toUri();
        return ResponseEntity.created(uri).body(CreationObjectDTO.builder()
                .id(phonebook.getId())
                .uri("/phonebook/get/" + phonebook.getId())
                .build()
        );
    }
}
