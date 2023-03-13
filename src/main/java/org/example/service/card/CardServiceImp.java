package org.example.service.card;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.dto.requests.CardRequestDto;
import org.example.dto.responses.CardResponseDto;
import org.example.models.CardEntity;
import org.example.models.DrinkEntity;
import org.modelmapper.ModelMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

public class CardServiceImp implements CardService{

    static ModelMapper modelMapper=new ModelMapper();

    @Override
    public boolean create(CardRequestDto cardRequestDto) {
        return false;
    }

    @Override
    public CardResponseDto get(UUID id) {
        return null;
    }

    @Override
    public List<CardResponseDto> getList() {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(UUID id, CardRequestDto cardRequestDto) {
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
        return false;
    }

    @Override
    public CardEntity getEntity(UUID id) {
        return null;
    }
}
