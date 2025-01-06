package net.scit.backend.menu.entity;

import jakarta.persistence.*;
import lombok.*;
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
@Table(name="order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long orderId;

    // memberId FK
    //@ManyToOne
    //@JoinColumn(name="member_id", referencedColumnName = "member_id")
    //private MemberEntity member;

    // storeId FK
    //@ManyToOne
    //@JoinColumn(name="store_id", referencedColumnName = "store_id")
    //private StoreEntity store;

    @CurrentTimestamp
    @Column(name="order_date")
    private LocalDate orderDate;

    @ColumnDefault("true")
    @Column(name="is_group")
    private Boolean isGroup;

    public static OrderEntity toEntity(OrderDTO orderDTO) {
        return OrderEntity.builder()
                .orderId(orderDTO.getOrderId())
                .orderDate(orderDTO.getOrderDate())
                .isGroup(orderDTO.getIsGroup())
                .build();
    }
}
