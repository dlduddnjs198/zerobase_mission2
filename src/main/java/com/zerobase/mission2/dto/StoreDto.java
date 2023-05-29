package com.zerobase.mission2.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreDto {
    private Long id;
    private String name;
    private String location;
    private String description;
    private PartnerDto partner;
}
