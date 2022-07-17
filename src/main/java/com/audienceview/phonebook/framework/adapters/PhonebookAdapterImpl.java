package com.audienceview.phonebook.framework.adapters;

import com.audienceview.phonebook.datasources.repositories.PhonebookDAO;

public class PhonebookAdapterImpl {

    PhonebookDAO phonebookDAO;

    PhonebookAdapterImpl(PhonebookDAO phonebookDAO) {
        this.phonebookDAO = phonebookDAO;
    }
}
