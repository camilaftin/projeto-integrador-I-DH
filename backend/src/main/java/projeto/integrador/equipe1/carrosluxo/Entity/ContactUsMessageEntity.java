package projeto.integrador.equipe1.carrosluxo.Entity;

import jakarta.persistence.*;
import projeto.integrador.equipe1.carrosluxo.Dto.input.InputContactUsMessageDto;

@Entity(name = "contact_us_message")
public class ContactUsMessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    private String email;
    private String title;
    private String body;

    public ContactUsMessageEntity() {
    }

    public ContactUsMessageEntity(long id, String email, String title, String body) {
        this.id = id;
        this.email = email;
        this.title = title;
        this.body = body;
    }

    public ContactUsMessageEntity(InputContactUsMessageDto message) {
        this.email = message.getEmail();
        this.title = message.getTitle();
        this.body = message.getBody();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
