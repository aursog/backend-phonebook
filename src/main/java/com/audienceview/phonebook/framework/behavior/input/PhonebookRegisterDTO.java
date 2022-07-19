package com.audienceview.phonebook.framework.behavior.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhonebookRegisterDTO {
    private String fullname;
    private String phonenumber;
}
