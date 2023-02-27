package projeto.integrador.equipe1.carrosluxo.Dto;

import projeto.integrador.equipe1.carrosluxo.Entity.CarEntity;
import projeto.integrador.equipe1.carrosluxo.Entity.CategoryEntity;

public class CarDto {
    private String nameCar;
    private CategoryFullDto Category;

    public CarDto() {
    }

    public CarDto(long id, String nameCar, CategoryFullDto category) {
        this.nameCar = nameCar;
        this.Category = category;
    }

    public CarDto(CarEntity carEntity) {
        this.nameCar = carEntity.getNameCar();
        this.Category = new CategoryFullDto(carEntity.getCategory());
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public CategoryFullDto getCategory() {
        return Category;
    }

    public void setCategory(CategoryFullDto category) {
        Category = category;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "nameCar='" + nameCar + '\'' +
                ", Category=" + Category +
                '}';
    }

    public CarEntity toEntity() {
        CarEntity carEntity = new CarEntity();
        carEntity.setNameCar(this.getNameCar());
        carEntity.setCategory(new CategoryEntity());
        carEntity.setCategory(this.getCategory().toEntity());
        return carEntity;
    }
}

