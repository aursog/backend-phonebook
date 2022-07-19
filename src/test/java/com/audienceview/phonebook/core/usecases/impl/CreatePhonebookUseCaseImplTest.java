package com.audienceview.phonebook.core.usecases.impl;

import com.audienceview.phonebook.core.entities.Phonebook;
import com.audienceview.phonebook.core.usecases.CreatePhonebookUseCase;
import com.audienceview.phonebook.datasources.jpas.PhonebookJPA;
import com.audienceview.phonebook.framework.adapters.CreatePhonebookAdapter;
import com.audienceview.phonebook.framework.behavior.input.PhonebookRegisterDTO;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CreatePhonebookUseCaseImplTest {

    @Test
    void test_creationOfPhonebook() {
        CreatePhonebookAdapter adapter = Mockito.mock(CreatePhonebookAdapter.class);
        Mockito.when(adapter.save(any())).thenReturn(PhonebookJPA.builder()
                .id(10L)
                .fullname("Steven Mallory")
                .phone("123456789")
                .creationAt(LocalDateTime.of(2022, 7, 18, 22, 0, 0))
                .active(true)
                .build());

        CreatePhonebookUseCase useCase = new CreatePhonebookUseCaseImpl(adapter);
        Phonebook result = useCase.createPhonebook(PhonebookRegisterDTO.builder().build());

        ArgumentCaptor<PhonebookRegisterDTO> argumentCaptor = ArgumentCaptor.forClass(PhonebookRegisterDTO.class);
        verify(adapter, times(1)).save(argumentCaptor.capture());
        assertEquals(PhonebookRegisterDTO.class, argumentCaptor.getValue().getClass());

        assertEquals(10L, result.getId());
        assert(result.getFullname().equals("Steven Mallory"));
        assert(result.getPhone().equals("123456789"));
        assertTrue(result.getActive());
        assert(result.getCreationAt().isEqual(LocalDateTime.of(2022, 7, 18, 22, 0, 0)));
        assertNull(result.getModifyAt());
    }
}