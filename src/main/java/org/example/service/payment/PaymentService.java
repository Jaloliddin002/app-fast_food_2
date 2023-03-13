package org.example.service.payment;

import org.example.dto.requests.PaymentRequestDto;
import org.example.dto.responses.PaymentResponseDto;
import org.example.models.PaymentEntity;
import org.example.service.BaseService;

public interface PaymentService extends BaseService<PaymentRequestDto,
        PaymentResponseDto, PaymentEntity> {


}
