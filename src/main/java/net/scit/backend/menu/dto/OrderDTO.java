package net.scit.backend.menu.dto;

import lombok.*;
import net.scit.backend.menu.entity.OrderEntity;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderDTO {

    private Long orderId;
    //private Long memberId;
    //private Long storeId;
    private LocalDate orderDate;
    private Boolean isGroup;

    public static OrderDTO toDTO(OrderEntity orderEntity) {
        return OrderDTO.builder()
                .orderId(orderEntity.getOrderId())
                //.memberId(orderEntity.getMemberId()) // 누락된 필드 추가
                //.storeId(orderEntity.getStoreId())   // 누락된 필드 추가
                .orderDate(orderEntity.getOrderDate())
                .isGroup(orderEntity.getIsGroup())
                .build();
    }
}
