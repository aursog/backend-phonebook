package com.audienceview.phonebook.framework.adapters;

import com.audienceview.phonebook.datasources.jpas.PhonebookJPA;

import java.util.List;

public interface ListPhonebookAdapter {
    List<PhonebookJPA> findAll();
}
