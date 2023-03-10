package projeto.integrador.equipe1.carrosluxo.Dto.output.caracteristic;

import projeto.integrador.equipe1.carrosluxo.Entity.CaracteristicEntity;

public class OutputCaracteristicReadDto {
    private String name;
    private String icon;

    public OutputCaracteristicReadDto() {
    }

    public OutputCaracteristicReadDto(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public OutputCaracteristicReadDto(CaracteristicEntity caracteristic) {
        this.icon = caracteristic.getIcon();
        this.name = caracteristic.getName();
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
