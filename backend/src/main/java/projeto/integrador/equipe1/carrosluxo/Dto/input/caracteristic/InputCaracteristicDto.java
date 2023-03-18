package projeto.integrador.equipe1.carrosluxo.Dto.input.caracteristic;

public class InputCaracteristicDto {
    private String name;
    private String icon;

    public InputCaracteristicDto(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public InputCaracteristicDto() {
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
