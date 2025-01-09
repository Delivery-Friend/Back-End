package net.scit.backend.menu.dto;

import lombok.*;
import net.scit.backend.member.entity.MemberEntity;
import net.scit.backend.menu.entity.StoreEntity;
import net.scit.backend.menu.entity.MenuEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class RecommendDTO {

    private Long recommendId;       // 추천 ID
    private Long memberId;          // 추천한 회원 ID
    private Long storeId;           // 추천된 가게 ID
    private Long menuId;            // 추천된 메뉴 ID
    private String recommendation;  // 추천 이유 또는 설명

    // MemberEntity, StoreEntity, MenuEntity를 통해 RecommendDTO 변환
    public static RecommendDTO toDTO(MemberEntity memberEntity, StoreEntity storeEntity, MenuEntity menuEntity, String recommendation) {
        return RecommendDTO.builder()
                .memberId(memberEntity.getMemberId())
                .storeId(storeEntity.getStoreId())
                .menuId(menuEntity.getMenuId())
                .recommendation(recommendation)
                .build();
    }
}
