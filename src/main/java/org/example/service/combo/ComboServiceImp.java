package org.example.service.combo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.dto.requests.ComboRequestDto;
import org.example.dto.responses.ComboResponseDto;
import org.example.models.ComboEntity;
import org.example.models.DrinkEntity;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ComboServiceImp implements ComboService{

    static ModelMapper modelMapper=new ModelMapper();

    @Override
    public boolean create(ComboRequestDto comboRequestDto) {
        if (comboRequestDto.getDrinks()!=null&&comboRequestDto.getFoods()!=null&&comboRequestDto.getPrice()!=0){
            List<ComboEntity> data = getData();
            if (data == null)data=new ArrayList<>();
            data.add(modelMapper.map(comboRequestDto,ComboEntity.class));
            writeData(data);
            comboRequestDto.setDrinks(new ArrayList<>());
            comboRequestDto.setFoods(new ArrayList<>());
            return true;
        }
        return false;
    }

    @Override
    public ComboResponseDto get(UUID id) {
        List<ComboEntity> data = getData();
        if (data != null){
            for (ComboEntity combo : data) {
                if (combo.getId().equals(id)){
                    return modelMapper.map(combo,ComboResponseDto.class);
                }
            }
        }
        return null;
    }

    @Override
    public List<ComboResponseDto> getList() {
        List<ComboEntity> data = getData();
        if (data != null){
            List<ComboResponseDto> comboResponseDtoList=new ArrayList<>();
            for (ComboEntity combo : data) {
                comboResponseDtoList.add(modelMapper.map(combo,ComboResponseDto.class));
            }
            return comboResponseDtoList;
        }
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        List<ComboEntity> data = getData();
        if (data != null){
            for (ComboEntity combo : data) {
                if (combo.getId().equals(id)){
                    data.remove(combo);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(UUID id, ComboRequestDto comboRequestDto) {
        List<ComboEntity> data = getData();
        if (data != null){
            for (ComboEntity combo : data) {
                if (combo.getId().equals(id)){
                    data.remove(combo);
                    modelMapper.map(comboRequestDto,combo);
                    data.add(combo);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<ComboEntity> getData() {
        File file = new File("data/combo.json");
        Gson gson = new Gson();
        List<ComboEntity> comboEntityList;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            Type type = new TypeToken<List<ComboEntity>>() {}.getType();
            comboEntityList = gson.fromJson(bufferedReader,type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return comboEntityList;
    }

    @Override
    public boolean writeData(List<ComboEntity> data) {
        File file = new File("data/combo.json");
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
    public ComboEntity getEntity(UUID id) {
        List<ComboEntity> data = getData();
        if (data != null){
            for (ComboEntity combo : data) {
                if (combo.getId().equals(id)){
                    return combo;
                }
            }
        }
        return null;
    }
}
