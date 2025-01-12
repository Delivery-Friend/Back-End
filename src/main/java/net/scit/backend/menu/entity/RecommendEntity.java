package net.scit.backend.menu.entity;

import jakarta.persistence.*;
import lombok.*;
import net.scit.backend.member.entity.MemberEntity;
import net.scit.backend.menu.dto.RecommendDTO;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "recommend")
public class RecommendEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recommend_id")
    private Long recommendId;  // 추천 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;  // 추천한 회원 (ManyToOne)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private StoreEntity storeEntity;  // 추천된 가게 (ManyToOne)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private MenuEntity menuEntity;  // 추천된 메뉴 (ManyToOne)

    @Column(name = "recommendation")
    private String recommendation;  // 추천 이유 또는 설명

    // DTO에서 Entity로 변환
    public static RecommendEntity toEntity(RecommendDTO recommendDTO, MemberEntity memberEntity, StoreEntity storeEntity, MenuEntity menuEntity) {
        return RecommendEntity.builder()
                .recommendId(recommendDTO.getRecommendId())
                .memberEntity(memberEntity)  // 추천한 회원
                .storeEntity(storeEntity)    // 추천된 가게
                .menuEntity(menuEntity)      // 추천된 메뉴
                .recommendation(recommendDTO.getRecommendation())  // 추천 이유
                .build();
    }
}
