package net.scit.backend.menu.entity;

import jakarta.persistence.*;
import lombok.*;
import net.scit.backend.member.entity.MemberEntity;
import net.scit.backend.menu.dto.OrderDTO;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;  // 주문 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private MemberEntity memberEntity;  // 회원 (ManyToOne 관계)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    private StoreEntity storeEntity;  // 가게 (ManyToOne 관계)

    @CurrentTimestamp
    @Column(name = "order_date")
    private LocalDate orderDate;  // 주문 날짜

    @ColumnDefault("true")
    @Column(name = "is_group")
    private Boolean isGroup;  // 그룹 여부

    // DTO를 Entity로 변환하는 메서드
    public static OrderEntity toEntity(OrderDTO orderDTO, MemberEntity memberEntity, StoreEntity storeEntity) {
        return OrderEntity.builder()
                .orderId(orderDTO.getOrderId())
                .memberEntity(memberEntity)  // MemberEntity 설정
                .storeEntity(storeEntity)    // StoreEntity 설정
                .orderDate(orderDTO.getOrderDate())
                .isGroup(orderDTO.getIsGroup())
                .build();
    }
}
