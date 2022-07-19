package com.audienceview.phonebook.framework.adapters.impl;

import com.audienceview.phonebook.datasources.jpas.PhonebookJPA;
import com.audienceview.phonebook.datasources.repositories.PhonebookDAO;
import com.audienceview.phonebook.framework.adapters.DeletePhonebookAdapter;

import java.util.NoSuchElementException;

public class DeletePhonebookAdapterImpl implements DeletePhonebookAdapter {

    PhonebookDAO phonebookDAO;

    public DeletePhonebookAdapterImpl(PhonebookDAO phonebookDAO) {
        this.phonebookDAO = phonebookDAO;
    }

    @Override
    public PhonebookJPA deactivate(Long id) throws NoSuchElementException {
        PhonebookJPA phonebookJPA = phonebookDAO.findById(id).get();
        phonebookJPA.setActive(false);
        return phonebookDAO.save(phonebookJPA);
    }
}
