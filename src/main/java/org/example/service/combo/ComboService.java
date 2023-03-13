package org.example.service.combo;

import org.example.dto.requests.ComboRequestDto;
import org.example.dto.responses.ComboResponseDto;
import org.example.models.ComboEntity;
import org.example.service.BaseService;

public interface ComboService extends BaseService<ComboRequestDto, ComboResponseDto,
        ComboEntity> {

}
