package com.audienceview.phonebook.config;

import com.audienceview.phonebook.core.usecases.DeletePhonebookUseCase;
import com.audienceview.phonebook.core.usecases.impl.DeletePhonebookUseCaseImpl;
import com.audienceview.phonebook.datasources.repositories.PhonebookDAO;
import com.audienceview.phonebook.framework.adapters.DeletePhonebookAdapter;
import com.audienceview.phonebook.framework.adapters.impl.DeletePhonebookAdapterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeletePhonebookConfig {

    @Autowired
    PhonebookDAO phonebookDAO;

    @Bean
    public DeletePhonebookAdapter deletePhonebookAdapter() {
        return new DeletePhonebookAdapterImpl(phonebookDAO);
    }

    @Bean
    public DeletePhonebookUseCase deletePhonebookUseCase() {
        return new DeletePhonebookUseCaseImpl(deletePhonebookAdapter());
    }
}
