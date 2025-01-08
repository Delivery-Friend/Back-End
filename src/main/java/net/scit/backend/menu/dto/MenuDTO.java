package net.scit.backend.menu.dto;

import lombok.*;
import net.scit.backend.menu.entity.MenuEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MenuDTO {
    private Long menuId;
    private Long foodId;
    private Long orderId;
    private String menuName;
    private int price;
    private int cnt;

    public static MenuDTO toDTO(MenuEntity menuEntity) {
        return MenuDTO.builder()
                .menuId(menuEntity.getMenuId())
                .foodId(menuEntity.getFoodId())
                .orderId(menuEntity.getOrderId())
                .menuName(menuEntity.getMenuName())
                .price(menuEntity.getPrice())
                .cnt(menuEntity.getCnt())
                .build();
    }
}