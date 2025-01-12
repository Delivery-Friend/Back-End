package net.scit.backend.menu.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.scit.backend.menu.entity.MenuEntity;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class MenuDTO {

    private Long menuId;
    private Long foodId; // FoodEntity의 ID
    private Long orderId; // OrderEntity의 ID
    private String menuName;
    private int price;
    private int cnt;
    private LocalDateTime createDate;

    // Builder 메서드
    public static MenuDTO toDTO(MenuEntity menuEntity) {
        return MenuDTO.builder()
                .menuId(menuEntity.getMenuId())
                .foodId(menuEntity.getFoodEntity().getFoodId())
                .orderId(menuEntity.getOrderEntity().getOrderId())
                .menuName(menuEntity.getMenuName())
                .price(menuEntity.getPrice())
                .cnt(menuEntity.getCnt())
                .createDate(menuEntity.getCreateDate())
                .build();
    }
}

