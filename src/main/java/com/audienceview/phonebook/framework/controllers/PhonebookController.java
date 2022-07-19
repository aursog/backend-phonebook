package com.audienceview.phonebook.framework.controllers;

import com.audienceview.phonebook.core.usecases.CreatePhonebookUseCase;
import com.audienceview.phonebook.core.usecases.ListPhonebookUseCase;
import com.audienceview.phonebook.framework.behavior.input.PhonebookRegisterDTO;
import com.audienceview.phonebook.framework.presenters.CreatePhonebookPresenter;
import com.audienceview.phonebook.framework.presenters.ListPhonebookPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/phonebook")
public class PhonebookController {

    private CreatePhonebookPresenter createPresenter;
    private ListPhonebookPresenter listPresenter;
    private CreatePhonebookUseCase createUseCase;
    private ListPhonebookUseCase listUseCase;

    public PhonebookController(CreatePhonebookPresenter createPhonebookPresenter, ListPhonebookPresenter listPhonebookPresenter,
                               CreatePhonebookUseCase createPhonebookUseCase, ListPhonebookUseCase listPhonebookUseCase) {
        this.createPresenter = createPhonebookPresenter;
        this.listPresenter = listPhonebookPresenter;
        this.createUseCase = createPhonebookUseCase;
        this.listUseCase = listPhonebookUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPhonebook(@RequestBody PhonebookRegisterDTO registerDTO) {
        return createPresenter.present(createUseCase.createPhonebook(registerDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<?> listPhonebook() {
        return listPresenter.present(listUseCase.getListPhonebook());
    }
}
