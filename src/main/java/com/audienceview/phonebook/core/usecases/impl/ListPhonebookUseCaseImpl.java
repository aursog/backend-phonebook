package com.audienceview.phonebook.core.usecases.impl;

import com.audienceview.phonebook.core.entities.Phonebook;
import com.audienceview.phonebook.core.usecases.ListPhonebookUseCase;
import com.audienceview.phonebook.datasources.jpas.PhonebookJPA;
import com.audienceview.phonebook.framework.adapters.ListPhonebookAdapter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListPhonebookUseCaseImpl implements ListPhonebookUseCase {

    ListPhonebookAdapter adapter;

    public ListPhonebookUseCaseImpl(ListPhonebookAdapter listPhonebookAdapter) {
        this.adapter = listPhonebookAdapter;
    }

    @Override
    public List<Phonebook> getListPhonebook() {
        return adapter.findAll().stream()
                .filter(PhonebookJPA::getActive)
                .sorted(Comparator.comparing(PhonebookJPA::getId).reversed())
                .map(jpa -> new Phonebook.Builder()
                    .id(jpa.getId())
                    .fullname(jpa.getFullname())
                    .phone(jpa.getPhone())
                    .creationAt(jpa.getCreationAt())
                    .modifyAt(jpa.getModifyAt())
                    .active(jpa.getActive())
                    .build()
                )
                .collect(Collectors.toList());
    }
}
