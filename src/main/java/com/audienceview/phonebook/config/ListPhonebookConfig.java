package com.audienceview.phonebook.config;

import com.audienceview.phonebook.core.usecases.ListPhonebookUseCase;
import com.audienceview.phonebook.core.usecases.impl.ListPhonebookUseCaseImpl;
import com.audienceview.phonebook.datasources.repositories.PhonebookDAO;
import com.audienceview.phonebook.framework.adapters.ListPhonebookAdapter;
import com.audienceview.phonebook.framework.adapters.impl.ListPhonebookAdapterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListPhonebookConfig {

    @Autowired
    PhonebookDAO phonebookDAO;

    @Bean
    public ListPhonebookAdapter listPhonebookAdapter() {
        return new ListPhonebookAdapterImpl(phonebookDAO);
    }

    @Bean
    public ListPhonebookUseCase listPhonebookUseCase() {
        return new ListPhonebookUseCaseImpl(listPhonebookAdapter());
    }
}
