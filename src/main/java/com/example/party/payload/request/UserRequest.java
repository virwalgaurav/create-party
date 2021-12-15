package com.example.party.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRequest {
    @NotBlank
    @Size(min = 9, max = 9)
    @Pattern(regexp = "[\\s]*[0-9]*[1-9]+",message="Can not -ive ")
    private Integer ssn;
    @NotBlank
    private String email;
    private String state;
    private String city;
    private Integer zip;
    private String country;
    private String addressLine1;
}
