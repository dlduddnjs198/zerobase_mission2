package com.zerobase.mission2.dto.form;

import com.zerobase.mission2.dto.PartnerDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartnerSignUpForm {
    // 가게 정보
    private String storeName;
    private String location;
    private String description;

    // 일반 유저도 받는 정보
    private String password;
    private PartnerDto partner;
}
