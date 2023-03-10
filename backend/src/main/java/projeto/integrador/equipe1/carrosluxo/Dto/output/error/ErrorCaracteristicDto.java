package projeto.integrador.equipe1.carrosluxo.Dto.output.error;

public class ErrorCaracteristicDto {
    private String name;
    private String icon;

    public ErrorCaracteristicDto(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public ErrorCaracteristicDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
