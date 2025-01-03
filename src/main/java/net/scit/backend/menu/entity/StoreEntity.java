package net.scit.backend.menu.entity;

import jakarta.persistence.*;
import lombok.*;
import net.scit.backend.menu.dto.StoreDTO;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

@Entity
@Table(name="store")
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="store_id")
    private Long storeId;

    @Column(name="store_name")
    private String storeName;

    @Column(name="store_address")
    private  String storeAddress;


    public static StoreEntity toEntity(StoreDTO storeDTO){
        return StoreEntity.builder()
                .storeId(storeDTO.getStoreId())
                .storeName(storeDTO.getStoreName())
                .storeAddress(storeDTO.getStoreAddress())
                .build();
    }



}
