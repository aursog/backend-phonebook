package com.audienceview.phonebook.framework.controllers;

import com.audienceview.phonebook.core.entities.Phonebook;
import com.audienceview.phonebook.core.usecases.CreatePhonebookUseCase;
import com.audienceview.phonebook.core.usecases.ListPhonebookUseCase;
import com.audienceview.phonebook.framework.behavior.input.PhonebookRegisterDTO;
import com.audienceview.phonebook.framework.behavior.output.CreationObjectDTO;
import com.audienceview.phonebook.framework.behavior.output.PhonebookOutDTO;
import com.audienceview.phonebook.framework.presenters.CreatePhonebookPresenter;
import com.audienceview.phonebook.framework.presenters.ListPhonebookPresenter;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
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
        PhonebookController controller = new PhonebookController(presenter, null, null, useCase, null, null);

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

    @Test
    void test_listOfAllPhonebook() {
        ListPhonebookUseCase useCase = Mockito.mock(ListPhonebookUseCase.class);
        Mockito.when(useCase.getListPhonebook()).thenReturn(Arrays.asList(new Phonebook.Builder().id(10L).build()));

        ListPhonebookPresenter presenter = Mockito.mock(ListPhonebookPresenter.class);
        Mockito.when(presenter.present(anyList())).thenReturn(ResponseEntity.ok().body(Arrays.asList(PhonebookOutDTO.builder().id(10L).build())));

        PhonebookController controller = new PhonebookController(null, presenter, null,null, useCase, null);

        ResponseEntity response = controller.listPhonebook();

        ArgumentCaptor<List> listArgumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(useCase, times(1)).getListPhonebook();
        verify(presenter, times(1)).present(listArgumentCaptor.capture());
        assertEquals(Phonebook.class, listArgumentCaptor.getValue().get(0).getClass());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}