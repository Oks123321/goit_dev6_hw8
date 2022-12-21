package ua.goit.java.dev6.hw8.model.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.goit.java.dev6.hw8.model.Dao.RoleDao;


import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class UserDto {
    private UUID id;

    @Email
    @Size(max = 250)
    private String email;

    @Size(max = 250)
    private String password;

    @Size(max = 250)
    private String firstName;

    @Size(max = 250)
    private String lastName;

    private List<RoleDao> roles;


}
