package com.zerobase.mission2.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private Long id;
    private UserDto user;
    private StoreDto store;
    private LocalDateTime reservationTime;
}
