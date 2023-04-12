package projeto.integrador.equipe1.carrosluxo.Dto.output.Car;

import projeto.integrador.equipe1.carrosluxo.Entity.CarCaracteristicEntity;
import projeto.integrador.equipe1.carrosluxo.Entity.CarEntity;
import projeto.integrador.equipe1.carrosluxo.Entity.CaracteristicEntity;
import projeto.integrador.equipe1.carrosluxo.Entity.ImagesEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OutputCarCreateOrUpdateDto {
    private Long id;
    private String nameCar;

    private String descritpion;

    private Double price;

    private Integer year;

    private Boolean highlight;
    private OutputCarCategoryDto category;
    private OutputCarCityDto city;
    private Set<OutputCarImagesDto> images;
    private Set<OutputCarCaracteristicsDto> caracteristics;

    public OutputCarCreateOrUpdateDto() {
    }

    public OutputCarCreateOrUpdateDto(Long id, String nameCar, String descritpion, Double price, Integer year, Boolean highlight, OutputCarCategoryDto category, OutputCarCityDto city, Set<OutputCarImagesDto> images, Set<OutputCarCaracteristicsDto> caracteristics) {
        this.id = id;
        this.nameCar = nameCar;
        this.descritpion = descritpion;
        this.price = price;
        this.year = year;
        this.highlight = highlight;
        this.category = category;
        this.city = city;
        this.images = images;
        this.caracteristics = caracteristics;
    }

    public OutputCarCreateOrUpdateDto(CarEntity car) {
        this.id = car.getId();
        this.nameCar = car.getNameCar();
        this.descritpion = car.getDescritpion();
        this.price = car.getPrice();
        this.year = car.getYear();
        this.highlight = car.getHighlight();
        this.category = new OutputCarCategoryDto(car.getCategory());
        this.city = new OutputCarCityDto(car.getCities());
        Set<OutputCarImagesDto> images = new HashSet<>();
        List<ImagesEntity> lista = new ArrayList<>(car.getImages());
        lista.sort((e1, e2) -> e1.getId().compareTo(e2.getId()));
        for (ImagesEntity image : lista) {
            images.add(new OutputCarImagesDto(image));
        }
        this.images = images;
        Set<OutputCarCaracteristicsDto> list = new HashSet<>();
        for (CarCaracteristicEntity carCaracteristic : car.getCarCaracteristic()) {
            list.add(new OutputCarCaracteristicsDto(carCaracteristic));
        }
        this.caracteristics = list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getHighlight() {
        return highlight;
    }

    public void setHighlight(Boolean highlight) {
        this.highlight = highlight;
    }

    public OutputCarCategoryDto getCategory() {
        return category;
    }

    public void setCategory(OutputCarCategoryDto category) {
        this.category = category;
    }

    public OutputCarCityDto getCity() {
        return city;
    }

    public void setCity(OutputCarCityDto city) {
        this.city = city;
    }

    public Set<OutputCarImagesDto> getImages() {
        return images;
    }

    public void setImages(Set<OutputCarImagesDto> images) {
        this.images = images;
    }

    public Set<OutputCarCaracteristicsDto> getCaracteristics() {
        return caracteristics;
    }

    public void setCaracteristics(Set<OutputCarCaracteristicsDto> caracteristics) {
        this.caracteristics = caracteristics;
    }
}
