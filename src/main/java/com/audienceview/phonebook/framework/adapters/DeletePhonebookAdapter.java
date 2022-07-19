package com.audienceview.phonebook.framework.adapters;

import com.audienceview.phonebook.datasources.jpas.PhonebookJPA;

public interface DeletePhonebookAdapter {
    PhonebookJPA deactivate(Long id);
}
