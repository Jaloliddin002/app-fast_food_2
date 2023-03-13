package org.example.service.food;

import org.example.dto.requests.FoodRequestDto;
import org.example.dto.responses.FoodResponseDto;
import org.example.models.FoodEntity;
import org.example.service.BaseService;

public interface FoodService extends BaseService<FoodRequestDto,
        FoodResponseDto, FoodEntity> {

}
