package com.example.erp.service;

import com.example.erp.entity.Position;
import com.example.erp.mapper.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qzp
 * @date 2020/3/1
 */
@Service
public class PositionService {
    @Autowired
    private PositionMapper positionMapper;
    public List<Position> getAllPositions() {
        return positionMapper.getAll();
    }
}
