package com.zerobase.mission2.dto;

import com.zerobase.mission2.domain.Reservation;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private String userName;
    private LocalDateTime reservationTime;

    public static ReservationDto fromEntity(Reservation reservation){
        return ReservationDto.builder()
                .userName(reservation.getUser().getUsername())
                .reservationTime(reservation.getReservationTime())
                .build();
    }

    public static List<ReservationDto> fromEntityList(List<Reservation> reservations){
        List<ReservationDto> reservationList=new ArrayList<>();
        for(Reservation reservation : reservations){
            reservationList.add(fromEntity(reservation));
        }
        return reservationList;
    }
}
