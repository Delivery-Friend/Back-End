package net.scit.backend.menu.dto;

import lombok.*;
import net.scit.backend.menu.entity.StoreEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class StoreDTO {

    private Long storeId;
    private String storeName;
    private String storeAddress;

    public static StoreDTO toDTO(StoreEntity storeEntity) {
        return StoreDTO.builder()
                .storeId(storeEntity.getStoreId())
                .storeName(storeEntity.getStoreName())
                .storeAddress(storeEntity.getStoreAddress())
                .build();
    }
}
