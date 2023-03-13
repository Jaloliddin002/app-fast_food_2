package org.example.service.drink;

import org.example.dto.requests.DrinkRequestDto;
import org.example.dto.responses.DrinkResponseDto;
import org.example.models.DrinkEntity;
import org.example.service.BaseService;

public interface DrinkService extends BaseService<DrinkRequestDto,
        DrinkResponseDto, DrinkEntity> {

}
