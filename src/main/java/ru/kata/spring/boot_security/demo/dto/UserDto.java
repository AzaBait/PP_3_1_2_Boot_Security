package ru.kata.spring.boot_security.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@Data
@Component
@Setter
@Getter
public class UserDto {
    private static ModelMapper modelMapper = new ModelMapper();
    private Long id;
    private String username;
    private String password;
    private String email;
    private List<Long> roleIds;

    public static UserDto userToDto(User user){
        UserDto userDto = modelMapper.map(user,UserDto.class);
        List<Long> roleIds = new ArrayList<>();
        for(Role role: user.getRoles()) {
            roleIds.add(role.getId());
        }
        userDto.setRoleIds(roleIds);


        return userDto;
    }
    public static User dtoToEntity(UserDto userDto){
        User user = modelMapper.map(userDto,User.class);
        List<Role> roles = new ArrayList<>();
        for(Long roleId: userDto.getRoleIds()){
            Role role = new Role();
            role.setId(roleId);
            roles.add(role);
        }
        user.setRoles(roles);

        return user;
    }
}
