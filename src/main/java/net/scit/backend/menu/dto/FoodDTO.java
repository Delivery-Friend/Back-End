package net.scit.backend.menu.dto;

import lombok.*;
import net.scit.backend.menu.entity.FoodEntity;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class FoodDTO {

    private Long foodId;
    private String foodName;
    private String foodType;
    private String foodThema;

    // Entity -> DTO 변환 메서드
    public static FoodDTO toDTO(FoodEntity foodEntity) {
        return FoodDTO.builder()
                .foodId(foodEntity.getFoodId())
                .foodName(foodEntity.getFoodName())
                .foodType(foodEntity.getFoodType())
                .foodThema(foodEntity.getFoodThema())
                .build();
    }
}
