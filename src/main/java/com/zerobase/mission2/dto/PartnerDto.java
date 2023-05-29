package com.zerobase.mission2.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartnerDto {
    private Long id;
    private String username;
    private String email;
}
