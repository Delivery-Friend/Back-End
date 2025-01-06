package net.scit.backend.menu.entity;

import jakarta.persistence.*;
import lombok.*;
import net.scit.backend.menu.dto.MenuDTO;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

@Entity
@Table(name="menu")
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="menu_id")
    private Long menuId;

    @Column(name="food_id")
    private Long foodId;

    @Column(name="order_id")
    private Long orderId;

    @Column(name="menu_name")
    private String menuName;

    @Column(name="price")
    private int price;

    @Column(name="cnt")
    private int cnt;

    public static MenuEntity toEntity(MenuDTO menuDTO) {
        return MenuEntity.builder()
                .menuId(menuDTO.getMenuId())
                .foodId(menuDTO.getFoodId())
                .orderId(menuDTO.getOrderId())
                .menuName(menuDTO.getMenuName())
                .price(menuDTO.getPrice())
                .cnt(menuDTO.getCnt())
                .build();
    }
}
