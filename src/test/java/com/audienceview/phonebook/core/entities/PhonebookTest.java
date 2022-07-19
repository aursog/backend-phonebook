package com.audienceview.phonebook.core.entities;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookTest {

    @Test
    void test_buildObjectAndGetElements() {
        assertEquals(Phonebook.class, new Phonebook.Builder().build().getClass());

        Phonebook phonebook = new Phonebook.Builder()
                .id(10L)
                .fullname("Eric Elliot")
                .phone("123444555")
                .creationAt(LocalDateTime.of(2022, 7, 18, 22, 0, 0))
                .active(true)
                .build();

        assertEquals(10L, phonebook.getId());
        assert(phonebook.getFullname().equals("Eric Elliot"));
        assert(phonebook.getPhone().equals("123444555"));
        assert(phonebook.getCreationAt().isEqual(LocalDateTime.of(2022, 7, 18, 22, 0, 0)));
        assertNull(phonebook.getModifyAt());
        assert(phonebook.getActive());
    }
}