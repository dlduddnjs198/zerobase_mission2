package com.zerobase.mission2.dto;

import com.zerobase.mission2.domain.User;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;
    private String phone;

    public static UserDto fromEntity(User user){
        return UserDto.builder()
                .username(user.getUsername())
                .phone(user.getPhone())
                .build();
    }
}
