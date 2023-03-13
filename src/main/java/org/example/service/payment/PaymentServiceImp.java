package org.example.service.payment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.dto.requests.PaymentRequestDto;
import org.example.dto.responses.PaymentResponseDto;
import org.example.models.PaymentEntity;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

public class PaymentServiceImp implements PaymentService{

    static ModelMapper modelMapper=new ModelMapper();

    @Override
    public boolean create(PaymentRequestDto paymentRequestDto) {
        return false;
    }

    @Override
    public PaymentResponseDto get(UUID id) {
        return null;
    }

    @Override
    public List<PaymentResponseDto> getList() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(UUID id, PaymentRequestDto paymentRequestDto) {
        return false;
    }

    @Override
    public List<PaymentEntity> getData() {
        File file = new File("data/payments.json");
        Gson gson = new Gson();
        List<PaymentEntity> paymentEntityList = null;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            Type type = new TypeToken<List<PaymentEntity>>() {}.getType();
            paymentEntityList = gson.fromJson(bufferedReader,type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return paymentEntityList;
    }

    @Override
    public boolean writeData(List<PaymentEntity> data) {
        File file = new File("data/payments.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            String json = gson.toJson(data);
            bufferedWriter.write(json);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public PaymentEntity getEntity(UUID id) {
        return null;
    }
}
