package projeto.integrador.equipe1.carrosluxo.Dto.output.error;

public class ErrorLoginDto {
    String email;
    String password;

    public ErrorLoginDto() {
    }

    public ErrorLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
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
}
