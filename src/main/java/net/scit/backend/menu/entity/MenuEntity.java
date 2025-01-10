package net.scit.backend.menu.entity;


import java.time.LocalDateTime;

import net.scit.backend.menu.dto.MenuDTO;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

@Entity
@Table(name = "menu")
public class MenuEntity {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long menuId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private FoodEntity foodEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "price")
    private int price;

    @Column(name = "cnt")
    private int cnt;

    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDateTime createDate;

    public static MenuEntity toEntity(MenuDTO menuDTO, FoodEntity foodEntity, OrderEntity orderEntity) {
        return MenuEntity.builder()
                .menuId(menuDTO.getMenuId())
                .foodEntity(foodEntity)
                .orderEntity(orderEntity)
                .menuName(menuDTO.getMenuName())
                .price(menuDTO.getPrice())
                .cnt(menuDTO.getCnt())
                .build();
    }
}