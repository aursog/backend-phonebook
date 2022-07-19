package com.audienceview.phonebook.framework.presenters.impl;

import com.audienceview.phonebook.framework.behavior.output.DeleteObjectDTO;
import com.audienceview.phonebook.framework.presenters.DeletePhonebookPresenter;
import org.springframework.http.ResponseEntity;

public class DeletePhonebookPresenterImpl implements DeletePhonebookPresenter {

    @Override
    public ResponseEntity present(Boolean active) {
        if (!active)
            return ResponseEntity.ok().body(DeleteObjectDTO.builder().message("Phonebook successful deleted").build());

        return ResponseEntity.badRequest().body(DeleteObjectDTO.builder().message("Couldn't delete the selected phonebook").build());
    }
}
