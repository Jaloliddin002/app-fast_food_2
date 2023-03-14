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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PaymentServiceImp implements PaymentService{

    static ModelMapper modelMapper=new ModelMapper();

    @Override
    public boolean create(PaymentRequestDto paymentRequestDto) {
        if (paymentRequestDto.getAmount() != 0) {
            List<PaymentEntity> data = getData();
            if (data == null) data = new ArrayList<>();
            data.add(modelMapper.map(paymentRequestDto, PaymentEntity.class));
            writeData(data);
            paymentRequestDto.setFoods(new ArrayList<>());
            return true;
        }
        return false;
    }

    @Override
    public PaymentResponseDto get(UUID id) {
        List<PaymentEntity> data = getData();
        if (data != null){
            for (PaymentEntity payment : data) {
                if (payment.getId().equals(id)){
                    return modelMapper.map(payment,PaymentResponseDto.class);
                }
            }
        }
        return null;
    }

    @Override
    public List<PaymentResponseDto> getList() {
        List<PaymentEntity> data = getData();
        if (data != null){
            List<PaymentResponseDto> paymentResponseDto=new ArrayList<>();
            for (PaymentEntity payment : data) {
                paymentResponseDto.add(modelMapper.map(payment,PaymentResponseDto.class));
            }
            return paymentResponseDto;
        }
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        List<PaymentEntity> data = getData();
        if (data != null){
            for (PaymentEntity payment : data) {
                if (payment.getId().equals(id)){
                    data.remove(payment);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(UUID id, PaymentRequestDto paymentRequestDto) {
        List<PaymentEntity> data = getData();
        if (data != null){
            for (PaymentEntity payment : data) {
                if (payment.getId().equals(id)){
                    data.remove(payment);
                    modelMapper.map(paymentRequestDto,payment);
                    data.add(payment);
                    writeData(data);
                    return true;
                }
            }
        }
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
        List<PaymentEntity> data = getData();
        if (data != null){
            for (PaymentEntity payment : data) {
                if (payment.getId().equals(id)){
                    return payment;
                }
            }
        }
        return null;
    }
}
