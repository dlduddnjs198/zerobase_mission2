package com.zerobase.mission2.dto;

import com.zerobase.mission2.domain.Partner;
import com.zerobase.mission2.domain.Store;
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

    public static PartnerDto fromEntity(Partner partner){
        return PartnerDto.builder()
                .id(partner.getId())
                .username(partner.getUsername())
                .email(partner.getEmail())
                .build();
    }
}
