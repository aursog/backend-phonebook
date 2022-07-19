package com.audienceview.phonebook.core.usecases.impl;

import com.audienceview.phonebook.core.entities.Phonebook;
import com.audienceview.phonebook.core.usecases.ListPhonebookUseCase;
import com.audienceview.phonebook.datasources.jpas.PhonebookJPA;
import com.audienceview.phonebook.framework.adapters.ListPhonebookAdapter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ListPhonebookUseCaseImplTest {

    @Test
    void test_transformationBusinessLogic() {
        ListPhonebookAdapter adapter = Mockito.mock(ListPhonebookAdapter.class);
        Mockito.when(adapter.findAll()).thenReturn(Arrays.asList(
                PhonebookJPA.builder().id(10L).fullname("Steven Segal").phone("123123123").active(true).build(),
                PhonebookJPA.builder().id(11L).fullname("Martin Smith").phone("456456456").active(false).build()
        ));

        ListPhonebookUseCase useCase = new ListPhonebookUseCaseImpl(adapter);

        List<Phonebook> result = useCase.getListPhonebook();

        verify(adapter, times(1)).findAll();
        assertEquals(1, result.size());
        assertEquals(10L, result.get(0).getId());
        assert(result.get(0).getFullname().equals("Steven Segal"));
        assert(result.get(0).getPhone().equals("123123123"));
    }

}