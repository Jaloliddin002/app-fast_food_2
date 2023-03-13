package org.example.service.drink;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.dto.requests.DrinkRequestDto;
import org.example.dto.responses.DrinkResponseDto;
import org.example.models.DrinkEntity;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DrinkServiceImp implements DrinkService{

    static ModelMapper modelMapper=new ModelMapper();

    @Override
    public boolean create(DrinkRequestDto drinkRequestDto) {
        return false;
    }

    @Override
    public DrinkResponseDto get(UUID id) {
        List<DrinkEntity> data = getData();
        if (data != null){
            for (DrinkEntity drink : data) {
                if (drink.getId().equals(id)){
                    return modelMapper.map(drink,DrinkResponseDto.class);
                }
            }
        }
        return null;
    }

    @Override
    public List<DrinkResponseDto> getList() {
        List<DrinkEntity> data = getData();
        if (data != null){
            List<DrinkResponseDto> drinkResponseDtoList=new ArrayList<>();
            for (DrinkEntity drink : data) {
                drinkResponseDtoList.add(modelMapper.map(drink,DrinkResponseDto.class));
            }
            return drinkResponseDtoList;
        }
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        List<DrinkEntity> data = getData();
        if (data != null){
            for (DrinkEntity drink : data) {
                if (drink.getId().equals(id)){
                    data.remove(drink);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(UUID id, DrinkRequestDto drinkRequestDto) {
        List<DrinkEntity> data = getData();
        if (data != null){
            for (DrinkEntity drink : data) {
                if (drink.getId().equals(id)){
                    data.remove(drink);
                    modelMapper.map(drinkRequestDto,drink);
                    data.add(drink);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<DrinkEntity> getData() {
        File file = new File("data/drinks.json");
        Gson gson = new Gson();
        List<DrinkEntity> drinkEntities = null;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            Type type = new TypeToken<List<DrinkEntity>>() {}.getType();
            drinkEntities = gson.fromJson(bufferedReader,type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return drinkEntities;
    }

    @Override
    public boolean writeData(List<DrinkEntity> data) {
        File file = new File("data/drinks.json");
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
    public DrinkEntity getEntity(UUID id) {
        List<DrinkEntity> data = getData();
        if (data != null){
            for (DrinkEntity drink : data) {
                if (drink.getId().equals(id)){
                    return drink;
                }
            }
        }
        return null;
    }
}
