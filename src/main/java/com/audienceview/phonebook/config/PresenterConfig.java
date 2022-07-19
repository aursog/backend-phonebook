package com.audienceview.phonebook.config;

import com.audienceview.phonebook.framework.presenters.CreatePhonebookPresenter;
import com.audienceview.phonebook.framework.presenters.ListPhonebookPresenter;
import com.audienceview.phonebook.framework.presenters.impl.CreatePhonebookPresenterImpl;
import com.audienceview.phonebook.framework.presenters.impl.ListPhonebookPresenterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PresenterConfig {

    @Bean
    public CreatePhonebookPresenter createPhonebookPresenter() {
        return new CreatePhonebookPresenterImpl();
    }

    @Bean
    public ListPhonebookPresenter listPhonebookPresenter() { return new ListPhonebookPresenterImpl(); }

}
