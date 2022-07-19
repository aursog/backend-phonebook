package com.audienceview.phonebook.core.usecases;

import com.audienceview.phonebook.core.entities.Phonebook;
import com.audienceview.phonebook.framework.behavior.input.PhonebookRegisterDTO;

public interface CreatePhonebookUseCase {
    Phonebook createPhonebook(PhonebookRegisterDTO phonebookRegisterDTO);
}
