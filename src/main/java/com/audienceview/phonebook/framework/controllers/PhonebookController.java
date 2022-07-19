package com.audienceview.phonebook.framework.controllers;

import com.audienceview.phonebook.core.usecases.CreatePhonebookUseCase;
import com.audienceview.phonebook.core.usecases.DeletePhonebookUseCase;
import com.audienceview.phonebook.core.usecases.ListPhonebookUseCase;
import com.audienceview.phonebook.framework.behavior.input.PhonebookRegisterDTO;
import com.audienceview.phonebook.framework.presenters.CreatePhonebookPresenter;
import com.audienceview.phonebook.framework.presenters.DeletePhonebookPresenter;
import com.audienceview.phonebook.framework.presenters.ListPhonebookPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Phonebook Controller.
 *
 * This controller manage all the management of phonebook object. This controller maybe could be 3 different controllers
 * separated by action, but I would prefer get a separation by responsibility. In this case, this controller is responsible
 * for all the management of the Phonebook actions: creation / listAll / delete (activate / deactivate).
 *
 * @version 1.0.0
 * @author Anggelo Urso
 */

@RestController
@RequestMapping("/phonebook")
@CrossOrigin
public class PhonebookController {

    private CreatePhonebookPresenter createPresenter;
    private ListPhonebookPresenter listPresenter;
    private CreatePhonebookUseCase createUseCase;
    private ListPhonebookUseCase listUseCase;
    private DeletePhonebookUseCase deleteUseCase;
    private DeletePhonebookPresenter deletePresenter;

    public PhonebookController(CreatePhonebookPresenter createPhonebookPresenter, ListPhonebookPresenter listPhonebookPresenter,
                               DeletePhonebookPresenter deletePhonebookPresenter, CreatePhonebookUseCase createPhonebookUseCase,
                               ListPhonebookUseCase listPhonebookUseCase, DeletePhonebookUseCase deletePhonebookUseCase) {
        this.createPresenter = createPhonebookPresenter;
        this.listPresenter = listPhonebookPresenter;
        this.deletePresenter = deletePhonebookPresenter;
        this.createUseCase = createPhonebookUseCase;
        this.listUseCase = listPhonebookUseCase;
        this.deleteUseCase = deletePhonebookUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPhonebook(@RequestBody PhonebookRegisterDTO registerDTO) {
        return createPresenter.present(createUseCase.createPhonebook(registerDTO));
    }

    @GetMapping("/list")
    public ResponseEntity<?> listPhonebook() {
        return listPresenter.present(listUseCase.getListPhonebook());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deactivatePhonebookRegister(@PathVariable Long id) {
        return deletePresenter.present(deleteUseCase.deletePhonebookRegister(id));
    }
}
