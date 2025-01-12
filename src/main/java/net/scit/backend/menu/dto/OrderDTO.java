package net.scit.backend.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.scit.backend.menu.entity.OrderEntity;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderDTO {

    private Long orderId;       // 주문 ID
    private Long memberId;      // 회원 ID (Member 테이블 참조)
    private Long storeId;       // 가게 ID (Store 테이블 참조)
    private LocalDate orderDate;// 주문 날짜
    private Boolean isGroup;    // 그룹 주문 여부

    // Entity를 DTO로 변환하는 메서드
    public static OrderDTO toDTO(OrderEntity orderEntity) {
        return OrderDTO.builder()
                .orderId(orderEntity.getOrderId())
                .memberId(orderEntity.getMemberEntity().getMemberId())
                .storeId(orderEntity.getStoreEntity().getStoreId())

    }
}
