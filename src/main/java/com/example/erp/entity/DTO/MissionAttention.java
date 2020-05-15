package com.example.erp.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qzp
 * @date 2020/4/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionAttention {
    private Integer userId;
    private Integer missionId;
    private Boolean attention;
}
