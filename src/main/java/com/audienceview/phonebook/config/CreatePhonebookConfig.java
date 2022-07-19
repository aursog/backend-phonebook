package com.audienceview.phonebook.config;

import com.audienceview.phonebook.core.usecases.CreatePhonebookUseCase;
import com.audienceview.phonebook.core.usecases.impl.CreatePhonebookUseCaseImpl;
import com.audienceview.phonebook.datasources.repositories.PhonebookDAO;
import com.audienceview.phonebook.framework.adapters.CreatePhonebookAdapter;
import com.audienceview.phonebook.framework.adapters.impl.CreatePhonebookAdapterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatePhonebookConfig {

    @Autowired
    PhonebookDAO phonebookDAO;

    @Bean
    public CreatePhonebookAdapter createPhonebookAdapter() {
        return new CreatePhonebookAdapterImpl(phonebookDAO);
    }

    @Bean
    public CreatePhonebookUseCase createPhonebookUseCase() {
        return new CreatePhonebookUseCaseImpl(createPhonebookAdapter());
    }
}
