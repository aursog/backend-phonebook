package com.audienceview.phonebook.datasources.jpas;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "phonebook")
@Value
@Builder
@NoArgsConstructor
public class PhonebookJPA {

    @Id
    Long id = 0L;

    @Column
    String fullname = "";

    @Column
    String phone = "";

    @Column(name = "creation_at")
    LocalDateTime creationAt = LocalDateTime.now();

    @Column(name = "modify_at")
    LocalDateTime modifyAt = null;

    @Column
    Boolean active = false;

}
