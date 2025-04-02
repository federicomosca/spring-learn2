package it.dogs.learn2.controller;

import it.dogs.learn2.dto.UserRequestDTO;
import it.dogs.learn2.dto.UserResponseDTO;
import it.dogs.learn2.facade.definition.UserFacadeDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserFacadeDefinition userFacadeDefinition;

    @GetMapping("/details/{id}")
    public ResponseEntity<UserResponseDTO> getUserDetails(@PathVariable Long id) {
        return ResponseEntity.ok(userFacadeDefinition.getUserDetails(id));
    }

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userFacadeDefinition.getAllUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO requestDTO){
        return ResponseEntity.ok(userFacadeDefinition.createUser(requestDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id,
                                                      @RequestBody UserRequestDTO requestDTO) {
        return ResponseEntity.ok(userFacadeDefinition.updateUser(id, requestDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userFacadeDefinition.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
