package br.com.kirgh.app.mappers;

import br.com.kirgh.app.dtos.*;
import br.com.kirgh.app.entities.Address;
import br.com.kirgh.app.entities.User;
import br.com.kirgh.app.projections.UserCompleteProjection;
import br.com.kirgh.app.utils.Utils;

/**
 * The {@code UserMapper} class provides a static method to convert a {@code UserDTO} object to a {@code User} object in Java.
 */
public abstract class UserMapper {
    /**
     * The function converts a UserDTO object to a User object in Java.
     *
     * @param userDTO userDTO is an object of type UserDTO, which is a data transfer object that contains information about
     *                a user.
     * @return The method {@code userDTOToUser} is returning an instance of the {@code User} class, which is created based on the
     * information provided in the {@code UserDTO} object passed as a parameter.
     */
    public static User userDTOToUser(UserDTO userDTO) {
        User user = new User();

        user.setCpf(userDTO.cpf());
        user.setEmail(userDTO.email());
        user.setName(userDTO.name());
        user.setGender(userDTO.gender());
        user.setBirthDate(userDTO.birthDate());

        return user;
    }

    public static User userUpdateDTOToUser(UserUpdateDTO userUpdateDTO, User updateUser) {
        updateUser.setCpf(userUpdateDTO.cpf());
        updateUser.setEmail(userUpdateDTO.email());
        updateUser.setName(userUpdateDTO.name());
        updateUser.setGender(userUpdateDTO.gender());
        updateUser.setBirthDate(userUpdateDTO.birthDate());
        return updateUser;
    }

    public static UserCompleteDTO userCompleteProjectionToUserCompleteDTO(UserCompleteProjection userCompleteProjection) {
        return new UserCompleteDTO(Utils.convertBytesToUUID(userCompleteProjection.getId()),
                userCompleteProjection.getName(), userCompleteProjection.getBirthDate(), userCompleteProjection.getGender(), userCompleteProjection.getCpf(), userCompleteProjection.getEmail());
    }

}
