package com.abc.CRUDS.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Users")
public class User {

    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Integer edad;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date cumpleanos;
}
