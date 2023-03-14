package org.example.service.card;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.dto.requests.CardRequestDto;
import org.example.dto.responses.CardResponseDto;
import org.example.models.CardEntity;

import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CardServiceImp implements CardService{

    static ModelMapper modelMapper=new ModelMapper();

    @Override
    public boolean create(CardRequestDto cardRequestDto) {
        if (cardRequestDto.getOwner() != null && cardRequestDto.getCardType() != null){
            List<CardEntity> data = getData();
            if (data == null)data=new ArrayList<>();
            data.add(modelMapper.map(cardRequestDto,CardEntity.class));
            writeData(data);
            return true;
        }
        return false;
    }

    @Override
    public CardResponseDto get(UUID id) {
        List<CardEntity> data = getData();
        if (data != null){
            for (CardEntity datum : data) {
                if (datum.getId().equals(id)){
                    return modelMapper.map(datum,CardResponseDto.class);
                }
            }
        }
        return null;
    }

    @Override
    public List<CardResponseDto> getList() {
        List<CardEntity> data = getData();
        if (data !=null){
            List<CardResponseDto> responseDto=new ArrayList<>();
            for (CardEntity card : data) {
                responseDto.add(modelMapper.map(card,CardResponseDto.class));
            }
            return responseDto;
        }
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        List<CardEntity> data = getData();
        if (data != null){
            for (CardEntity card : data) {
                if (card.getId().equals(id)){
                    data.remove(card);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(UUID id, CardRequestDto cardRequestDto) {
        List<CardEntity> data = getData();
        if (data != null){
            for (CardEntity card : data) {
                if (card.getId().equals(id)){
                    data.remove(card);
                    modelMapper.map(cardRequestDto,card);
                    data.add(card);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<CardEntity> getData() {
        File file = new File("data/cards.json");
        Gson gson = new Gson();
        List<CardEntity> cardEntities;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            Type type = new TypeToken<List<CardEntity>>() {}.getType();
            cardEntities = gson.fromJson(bufferedReader,type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cardEntities;

    }

    @Override
    public boolean writeData(List<CardEntity> data) {
        File file=new File("data/cards.json");
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try (BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file))){
            bufferedWriter.write(gson.toJson(data));
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public CardEntity getEntity(UUID id) {
        List<CardEntity> data = getData();
        if (data != null){
            for (CardEntity card : data) {
                if (card.getId().equals(id)){
                    return card;
                }
            }
        }
        return null;
    }
}
