package org.example.service.card;

import org.example.dto.requests.CardRequestDto;
import org.example.dto.responses.CardResponseDto;
import org.example.models.CardEntity;
import org.example.service.BaseService;

public interface CardService extends BaseService<CardRequestDto, CardResponseDto, CardEntity> {

}
