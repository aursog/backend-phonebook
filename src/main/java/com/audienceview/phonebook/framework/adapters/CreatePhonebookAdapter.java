package com.audienceview.phonebook.framework.adapters;

import com.audienceview.phonebook.datasources.jpas.PhonebookJPA;
import com.audienceview.phonebook.framework.behavior.input.PhonebookRegisterDTO;

public interface CreatePhonebookAdapter {
    PhonebookJPA save(PhonebookRegisterDTO phonebookRegisterDTO);
}
