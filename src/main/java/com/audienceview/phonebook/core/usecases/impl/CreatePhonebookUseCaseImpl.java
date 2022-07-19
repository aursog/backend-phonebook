package com.audienceview.phonebook.core.usecases.impl;

import com.audienceview.phonebook.core.entities.Phonebook;
import com.audienceview.phonebook.core.usecases.CreatePhonebookUseCase;
import com.audienceview.phonebook.datasources.jpas.PhonebookJPA;
import com.audienceview.phonebook.framework.adapters.CreatePhonebookAdapter;
import com.audienceview.phonebook.framework.behavior.input.PhonebookRegisterDTO;

public class CreatePhonebookUseCaseImpl implements CreatePhonebookUseCase {

    CreatePhonebookAdapter adapter;

    public CreatePhonebookUseCaseImpl(CreatePhonebookAdapter createPhonebookAdapter) {
        this.adapter = createPhonebookAdapter;
    }

    @Override
    public Phonebook createPhonebook(PhonebookRegisterDTO phonebookRegisterDTO) {
        PhonebookJPA phonebookJPA = adapter.save(phonebookRegisterDTO);
        return new Phonebook.Builder()
                .id(phonebookJPA.getId())
                .fullname(phonebookJPA.getFullname())
                .phone(phonebookJPA.getPhone())
                .creationAt(phonebookJPA.getCreationAt())
                .modifyAt(phonebookJPA.getModifyAt())
                .active(phonebookJPA.getActive())
                .build();
    }
}
