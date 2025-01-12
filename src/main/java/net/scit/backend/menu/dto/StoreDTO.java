package net.scit.backend.menu.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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

    public static StoreDTO toDTO(StoreEntity storeEntity){
        return StoreDTO.builder()
                .storeId(storeEntity.getStoreId())
                .storeName(storeEntity.getStoreName())
                .storeAddress(storeEntity.getStoreAddress())
                .build();
    }
}
