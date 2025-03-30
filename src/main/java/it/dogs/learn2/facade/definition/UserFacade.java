package it.dogs.learn2.facade.definition;

import it.dogs.learn2.dto.UserRequestDTO;
import it.dogs.learn2.dto.UserResponseDTO;

import java.util.List;

public interface UserFacade {
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO createUser(UserRequestDTO requestDTO);
    UserResponseDTO updateUser(Long id, UserRequestDTO requestDTO);
    UserResponseDTO getUserDetails(Long id);
    void deleteUser(Long id);
}
