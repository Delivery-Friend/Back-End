package net.scit.backend.menu.entity;

import jakarta.persistence.*;
import lombok.*;
import net.scit.backend.group.entity.GroupEntity;
import net.scit.backend.menu.dto.RecordDTO;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Builder
@Table(name = "record")
public class RecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long recordId;  // 주문 기록 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private StoreEntity storeEntity;  // 가게 (ManyToOne 관계)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private MenuEntity menuEntity;  // 메뉴 (ManyToOne 관계)

    @Column(name = "price")
    private int price;  // 가격

    @Column(name = "cnt")
    private int cnt;  // 수량

    @Column(name = "order_date")
    private LocalDate orderDate;  // 주문 날짜

    @Column(name = "is_group")
    private boolean isGroup;  // 그룹 여부 (그룹 주문 여부)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private GroupEntity groupEntity;  // 그룹 (ManyToOne 관계, 그룹 주문일 경우)

    // RecordEntity를 RecordDTO로 변환하는 메서드
    public static RecordEntity toEntity(RecordDTO recordDTO, StoreEntity storeEntity, MenuEntity menuEntity, GroupEntity groupEntity) {
        return RecordEntity.builder()
                .recordId(recordDTO.getRecordId())
                .storeEntity(storeEntity)  // 가게
                .menuEntity(menuEntity)    // 메뉴
                .price(recordDTO.getPrice())
                .cnt(recordDTO.getCnt())
                .orderDate(recordDTO.getOrderDate())
                .isGroup(recordDTO.isGroup())
                .groupEntity(groupEntity)  // 그룹 (있을 경우)
                .build();
    }
}
