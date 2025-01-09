package net.scit.backend.menu.dto;

import lombok.*;
import net.scit.backend.menu.entity.RecordEntity;
import net.scit.backend.menu.entity.StoreEntity;
import net.scit.backend.menu.entity.MenuEntity;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class RecordDTO {

    private Long recordId;      // 주문 기록 ID
    private Long storeId;       // 가게 ID
    private String storeName;   // 가게 이름
    private String menuName;    // 메뉴 이름
    private int price;          // 가격
    private int cnt;            // 수량
    private LocalDate orderDate;// 주문 날짜
    private boolean isGroup;    // 그룹 주문 여부

    // Entity를 DTO로 변환하는 메서드
    public static RecordDTO toDTO(RecordEntity recordEntity) {
        return RecordDTO.builder()
                .recordId(recordEntity.getRecordId())
                .storeId(recordEntity.getStoreEntity().getStoreId())       // StoreEntity에서 storeId 가져오기
                .storeName(recordEntity.getStoreEntity().getStoreName())   // StoreEntity에서 storeName 가져오기
                .menuName(recordEntity.getMenuEntity().getMenuName())      // MenuEntity에서 menuName 가져오기
                .price(recordEntity.getPrice())
                .cnt(recordEntity.getCnt())
                .orderDate(recordEntity.getOrderDate())
                .isGroup(recordEntity.isGroup())  // 그룹 주문 여부
                .build();
    }
}
