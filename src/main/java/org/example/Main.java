package org.example;

import org.example.dto.requests.UserRequestDto;
import org.example.dto.responses.UserResponseDto;
import org.example.enums.Role;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImp;

import java.util.Scanner;

public class Main implements Constant{


    static Scanner scannerInt=new Scanner(System.in);
    static Scanner scannerStr=new Scanner(System.in);

    static UserRequestDto userRequestDto=new UserRequestDto();
    static UserService userService=new UserServiceImp();
    public static void main(String[] args) {
        userService.setOwner();
        while (true){
            System.out.println(ENTRANCE);
            int option = scannerInt.nextInt();
            if (option == 0)break;
            else if (option == 1)signUp();
            else if (option == 2)signIn();
            else System.out.println(WRONG_OPTION);
        }
    }

    private static void signUp() {
        System.out.print(ENTER_PHONE_NUMBER);
        String phoneNumber = scannerStr.nextLine();
        System.out.print("Enter password : ");
        String password=scannerStr.nextLine();
        System.out.print("Enter name : ");
        String name = scannerStr.nextLine();
        UserRequestDto userRequestDto=UserRequestDto.builder()
                .phoneNumber(phoneNumber).password(password).name(name)
                .build();
        boolean result = userService.create(userRequestDto);
        if (result){
            System.out.println(SUCCESSFULLY_COMPLETED);
        }else System.out.println(ERROR);
    }

    private static void signIn() {
        System.out.println(ENTER_PHONE_NUMBER);
        String phoneNumber = scannerStr.nextLine();
        System.out.println("Enter password : ");
        String password = scannerStr.nextLine();
        UserResponseDto userResponseDto = userService.get(phoneNumber);
        if (userResponseDto != null && userResponseDto.getPassword().equals(password)){
            if (userResponseDto.getRole().equals(Role.OWNER.name())){
                ownerPage();
            } else if (userResponseDto.getRole().equals(Role.ADMIN.name())) {
                adminPage();
            }else {
                userPage();
            }
        }
    }

    private static void ownerPage() {

    }

    private static void adminPage() {

    }

    private static void userPage() {

    }
}
