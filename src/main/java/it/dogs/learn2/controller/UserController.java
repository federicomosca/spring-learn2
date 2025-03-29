package it.dogs.learn2.controller;

import it.dogs.learn2.dto.UserRequestDTO;
import it.dogs.learn2.dto.UserResponseDTO;
import it.dogs.learn2.facade.definition.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userFacade.getAllUsers();
    }

    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO requestDTO){
        return userFacade.createUser(requestDTO);
    }
}
