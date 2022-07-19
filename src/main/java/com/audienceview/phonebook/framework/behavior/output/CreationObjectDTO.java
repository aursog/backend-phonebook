package com.audienceview.phonebook.framework.behavior.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreationObjectDTO implements Serializable {
    private Long id;
    private String uri;
}
