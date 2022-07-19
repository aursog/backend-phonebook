package com.audienceview.phonebook.datasources.jpas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "phonebook")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhonebookJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String fullname;

    @Column
    private String phone;

    @Column(name = "creation_at")
    private LocalDateTime creationAt;

    @Column(name = "modify_at")
    private LocalDateTime modifyAt;

    @Column
    private Boolean active;

}
