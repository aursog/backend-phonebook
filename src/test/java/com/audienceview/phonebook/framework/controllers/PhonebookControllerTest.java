package com.audienceview.phonebook.framework.controllers;

import com.audienceview.phonebook.core.entities.Phonebook;
import com.audienceview.phonebook.core.usecases.CreatePhonebookUseCase;
import com.audienceview.phonebook.framework.behavior.input.PhonebookRegisterDTO;
import com.audienceview.phonebook.framework.behavior.output.CreationObjectDTO;
import com.audienceview.phonebook.framework.presenters.CreatePhonebookPresenter;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class PhonebookControllerTest {

    @Test
    void test_creationOfPhonebook() {
        CreatePhonebookUseCase useCase = Mockito.mock(CreatePhonebookUseCase.class);
        Mockito.when(useCase.createPhonebook(any(PhonebookRegisterDTO.class))).thenReturn(new Phonebook.Builder().id(10L).build());

        CreatePhonebookPresenter presenter = Mockito.mock(CreatePhonebookPresenter.class);
        URI uri = ServletUriComponentsBuilder.fromUriString("/phonebook/{id}").buildAndExpand(10).toUri();
        Mockito.when(presenter.present(any(Phonebook.class))).thenReturn(ResponseEntity.created(uri).body(CreationObjectDTO.builder().build()));
        PhonebookController controller = new PhonebookController(presenter, null, useCase, null);

        ResponseEntity response = controller.createPhonebook(PhonebookRegisterDTO.builder().build());

        ArgumentCaptor<PhonebookRegisterDTO> argumentCaptorUseCase = ArgumentCaptor.forClass(PhonebookRegisterDTO.class);
        ArgumentCaptor<Phonebook> argumentPresenterCaptor = ArgumentCaptor.forClass(Phonebook.class);

        verify(useCase, times(1)).createPhonebook(argumentCaptorUseCase.capture());
        verify(presenter, times(1)).present(argumentPresenterCaptor.capture());
        assertEquals(PhonebookRegisterDTO.class, argumentCaptorUseCase.getValue().getClass());
        assertEquals(Phonebook.class, argumentPresenterCaptor.getValue().getClass());

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assert(response.getHeaders().getLocation().getPath().equals("/phonebook/10"));
    }
}