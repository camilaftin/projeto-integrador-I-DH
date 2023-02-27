package projeto.integrador.equipe1.carrosluxo.Dto;

import projeto.integrador.equipe1.carrosluxo.Entity.UserEntity;
import projeto.integrador.equipe1.carrosluxo.Entity.UserRoles;

public class RegisterDto {
    private String firstName;
    private String surname;
    private String email;
    private String password;

    public RegisterDto() {
    }

    public RegisterDto(String firstName, String surname, String email, String password) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserEntity toEntity() {
        UserEntity user = new UserEntity();
        user.setFirstName(this.getFirstName().trim());
        user.setSurname(this.getSurname().trim());
        user.setEmail(this.getEmail().trim());
        user.setPassword(this.getPassword());
        user.setRoles(UserRoles.ROLE_USER);
        return user;
    }
}
