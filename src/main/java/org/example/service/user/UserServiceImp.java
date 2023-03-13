package org.example.service.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.dto.requests.UserRequestDto;
import org.example.dto.responses.UserResponseDto;
import org.example.enums.Role;
import org.example.models.UserEntity;
import org.modelmapper.ModelMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserServiceImp implements UserService{

    static ModelMapper modelMapper=new ModelMapper();

    @Override
    public boolean create(UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = get(userRequestDto.getPhoneNumber());
        if (userResponseDto == null){
            UserEntity userEntity=new UserEntity();
            modelMapper.map(userRequestDto,userEntity);
            List<UserEntity> userEntities = getData();
            if (userEntities == null){
                userEntities = new ArrayList<>();
            }
            userEntity.setRole(Role.USER);
            userEntities.add(userEntity);
            writeData(userEntities);
            return true;
        }
        return false;
    }

    @Override
    public UserResponseDto get(UUID id) {
        List<UserEntity> data = getData();
        if (data !=null){
            for (UserEntity user : data) {
                if(user.getId().equals(id)){
                    return modelMapper.map(user,UserResponseDto.class);
                }
            }
        }
        return null;
    }

    @Override
    public List<UserResponseDto> getList() {
        List<UserEntity> data = getData();
        if (data !=null){
            List<UserResponseDto> responseDto=new ArrayList<>();
            for (UserEntity user : data) {
                responseDto.add(modelMapper.map(user,UserResponseDto.class));
            }
            return responseDto;
        }
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        List<UserEntity> data = getData();
        if (data !=null){
            for (UserEntity user : data) {
                if (user.getId().equals(id)){
                    data.remove(user);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(UUID id, UserRequestDto userRequestDto) {
        List<UserEntity> data = getData();
        if (data !=null){
            for (UserEntity user : data) {
                if (user.getId().equals(id)){
                    data.remove(user);
                    modelMapper.map(userRequestDto,user);
                    data.add(user);
                    writeData(data);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<UserEntity> getData() {
        File file = new File("data/users.json");
        Gson gson = new Gson();
        List<UserEntity> userEntityList = null;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            Type type = new TypeToken<List<UserEntity>>() {}.getType();
            userEntityList = gson.fromJson(bufferedReader,type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return userEntityList;
    }

    @Override
    public boolean writeData(List<UserEntity> data) {
        File file = new File("data/users.json");
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
    public UserEntity getEntity(UUID id) {
        List<UserEntity> data = getData();
        if (data != null){
            for (UserEntity user : data) {
                if (user.getId().equals(id)){
                    return user;
                }
            }
        }
        return null;
    }

    @Override
    public UserResponseDto get(String phoneNumber) {
        List<UserEntity> data = getData();
        if (data !=null){
            for (UserEntity user : data) {
                if (user.getPhoneNumber().equals(phoneNumber)){
                    return modelMapper.map(user,UserResponseDto.class);
                }
            }
        }
        return null;
    }

    @Override
    public UserResponseDto setOwner() {
        return null;
    }
}
