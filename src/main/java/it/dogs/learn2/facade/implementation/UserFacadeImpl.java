package it.dogs.learn2.facade.implementation;

import it.dogs.learn2.dto.UserRequestDTO;
import it.dogs.learn2.dto.UserResponseDTO;
import it.dogs.learn2.facade.definition.UserFacade;
import it.dogs.learn2.model.User;
import it.dogs.learn2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.stream()
                .map(user -> new UserResponseDTO(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getBirthDate(),
                        user.getFiscalCode()))
                .toList();
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO requestDTO) {
        User user = new User();
        user.setFirstName(requestDTO.firstName());
        user.setLastName(requestDTO.lastName());
        user.setEmail(requestDTO.email());
        user.setBirthDate(requestDTO.birthDate());
        user.setFiscalCode(requestDTO.fiscalCode());

        User saved = userService.createUser(user);

        return new UserResponseDTO(
                saved.getId(),
                saved.getFirstName(),
                saved.getLastName(),
                saved.getEmail(),
                saved.getBirthDate(),
                saved.getFiscalCode()
        );
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO requestDTO) {
        User user = new User();
        user.setId(id);
        user.setFirstName(requestDTO.firstName());
        user.setLastName(requestDTO.lastName());
        user.setEmail(requestDTO.email());
        user.setBirthDate(requestDTO.birthDate());
        user.setFiscalCode(requestDTO.fiscalCode());

        User updated = userService.updateUser(user);

        return new UserResponseDTO(
                updated.getId(),
                updated.getFirstName(),
                updated.getLastName(),
                updated.getEmail(),
                updated.getBirthDate(),
                updated.getFiscalCode()
        );
    }

    @Override
    public UserResponseDTO getUserDetails(Long id) {
        User user = userService.getUserById(id);
        return new UserResponseDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getBirthDate(),
                user.getFiscalCode());
    }

    @Override
    public void deleteUser(Long id) {
        userService.deleteUserById(id);
    }
}
