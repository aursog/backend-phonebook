package com.audienceview.phonebook.framework.adapters.impl;

import com.audienceview.phonebook.datasources.jpas.PhonebookJPA;
import com.audienceview.phonebook.datasources.repositories.PhonebookDAO;
import com.audienceview.phonebook.framework.adapters.ListPhonebookAdapter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ListPhonebookAdapterImpl implements ListPhonebookAdapter {

    PhonebookDAO phonebookDAO;

    public ListPhonebookAdapterImpl(PhonebookDAO phonebookDAO) {
        this.phonebookDAO = phonebookDAO;
    }

    @Override
    public List<PhonebookJPA> findAll() {
        return StreamSupport.stream(phonebookDAO.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
