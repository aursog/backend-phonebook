package com.audienceview.phonebook.framework.adapters.impl;

import com.audienceview.phonebook.datasources.jpas.PhonebookJPA;
import com.audienceview.phonebook.datasources.repositories.PhonebookDAO;
import com.audienceview.phonebook.framework.adapters.CreatePhonebookAdapter;
import com.audienceview.phonebook.framework.behavior.input.PhonebookRegisterDTO;

import java.time.LocalDateTime;

public class CreatePhonebookAdapterImpl implements CreatePhonebookAdapter {

    PhonebookDAO phonebookDAO;

    public CreatePhonebookAdapterImpl(PhonebookDAO phonebookDAO) {
        this.phonebookDAO = phonebookDAO;
    }

    @Override
    public PhonebookJPA save(PhonebookRegisterDTO phonebookRegisterDTO) throws IllegalArgumentException {
        return phonebookDAO.save(PhonebookJPA.builder()
                .fullname(phonebookRegisterDTO.getFullname())
                .phone(phonebookRegisterDTO.getPhonenumber())
                .creationAt(LocalDateTime.now())
                .active(true)
                .build());
    }
}
