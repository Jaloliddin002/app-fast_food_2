package org.example.service.food;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.dto.requests.FoodRequestDto;
import org.example.dto.responses.FoodResponseDto;
import org.example.models.FoodEntity;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FoodServiceImp implements FoodService{

    static ModelMapper modelMapper=new ModelMapper();

    @Override
    public boolean create(FoodRequestDto foodRequestDto) {
        return false;
    }

    @Override
    public FoodResponseDto get(UUID id) {
        List<FoodEntity> data = getData();
        if(data != null){
            for (FoodEntity food : data) {
                if (food.getId().equals(id)){
                    return modelMapper.map(food,FoodResponseDto.class);
                }
            }
        }
        return null;
    }

    @Override
    public List<FoodResponseDto> getList() {
        List<FoodEntity> data = getData();
        if (data != null){
            List<FoodResponseDto> foodResponseDto=new ArrayList<>();
            for (FoodEntity food : data) {
                foodResponseDto.add(modelMapper.map(food,FoodResponseDto.class));
            }
            return foodResponseDto;
        }
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        List<FoodEntity> data = getData();
        if (data != null){
            for (FoodEntity food : data) {
                if (food.getId().equals(id)){
                    data.remove(food);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(UUID id, FoodRequestDto foodRequestDto) {
        List<FoodEntity> data = getData();
        if (data != null){
            for (FoodEntity food : data) {
                if (food.getId().equals(id)){
                    data.remove(food);
                    modelMapper.map(foodRequestDto,food);
                    data.add(food);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<FoodEntity> getData() {
        File file = new File("data/foods.json");
        Gson gson = new Gson();
        List<FoodEntity> foodEntityList = null;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            Type type = new TypeToken<List<FoodEntity>>() {}.getType();
            foodEntityList = gson.fromJson(bufferedReader,type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return foodEntityList;
    }

    @Override
    public boolean writeData(List<FoodEntity> data) {
        File file = new File("data/foods.json");
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
    public FoodEntity getEntity(UUID id) {
        List<FoodEntity> data = getData();
        if (data != null){
            for (FoodEntity food : data) {
                if (food.getId().equals(id)){
                    return food;
                }
            }
        }
        return null;
    }
}
