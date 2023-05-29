package com.zerobase.mission2.dto.form;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpForm {
    private Long id;
    private String username;
    private String password;
    private String email;
}
