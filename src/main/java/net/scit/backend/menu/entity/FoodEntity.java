package net.scit.backend.menu.entity;

import jakarta.persistence.*;
import lombok.*;
import net.scit.backend.menu.dto.FoodDTO;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

@Entity
@Table(name = "food")
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long foodId;

    @Column(name = "food_name", nullable = false)
    private String foodName;

    @Column(name = "food_type", nullable = false)
    private String foodType;

    @Column(name = "food_thema")
    private String foodThema;

    // DTO -> Entity 변환 메서드
    public static FoodEntity toEntity(FoodDTO foodDTO) {
        return FoodEntity.builder()
                .foodId(foodDTO.getFoodId())
                .foodName(foodDTO.getFoodName())
                .foodType(foodDTO.getFoodType())
                .foodThema(foodDTO.getFoodThema())
                .build();
    }
}
