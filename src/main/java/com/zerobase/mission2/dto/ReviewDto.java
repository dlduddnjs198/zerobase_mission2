package com.zerobase.mission2.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private Long id;
    private UserDto user;
    private StoreDto store;
    private int rating;
    private String comment;
}
