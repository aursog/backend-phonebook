package com.audienceview.phonebook.core.usecases.impl;

import com.audienceview.phonebook.core.usecases.DeletePhonebookUseCase;
import com.audienceview.phonebook.framework.adapters.DeletePhonebookAdapter;

import java.util.NoSuchElementException;

public class DeletePhonebookUseCaseImpl implements DeletePhonebookUseCase {

    DeletePhonebookAdapter adapter;

    public DeletePhonebookUseCaseImpl(DeletePhonebookAdapter deletePhonebookAdapter) {
        this.adapter = deletePhonebookAdapter;
    }

    @Override
    public Boolean deletePhonebookRegister(Long id) throws NoSuchElementException {
        return adapter.deactivate(id).getActive();
    }
}
