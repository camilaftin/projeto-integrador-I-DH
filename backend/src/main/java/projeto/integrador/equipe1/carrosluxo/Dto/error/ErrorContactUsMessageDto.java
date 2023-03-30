package projeto.integrador.equipe1.carrosluxo.Dto.error;

public class ErrorContactUsMessageDto {
    private String email;
    private String title;
    private String body;

    public ErrorContactUsMessageDto() {
    }

    public ErrorContactUsMessageDto(String email, String title, String body) {
        this.email = email;
        this.title = title;
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
