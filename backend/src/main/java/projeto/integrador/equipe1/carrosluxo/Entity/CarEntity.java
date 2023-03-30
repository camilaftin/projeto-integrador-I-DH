package projeto.integrador.equipe1.carrosluxo.Entity;

import jakarta.persistence.*;
import projeto.integrador.equipe1.carrosluxo.Dto.input.car.InputCarDto;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "cars")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "name_car")
    private String nameCar;

    private String descritpion;

    private Double price;

    @Column(name = "year_car")
    private Integer year;

    private Boolean highlight;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CitiesEntity cities;

    @OneToMany(mappedBy = "car")
    private Set<ImagesEntity> images = new HashSet<>();

    @OneToMany(mappedBy = "car")
    private Set<BookingEntity> bookings = new HashSet<>();

    @OneToMany(mappedBy = "car")
    private Set<CarCaracteristicEntity> carCaracteristic = new HashSet<>();

    public CarEntity() {
    }

    public CarEntity(long id, String nameCar, String descritpion, Double price, Integer year, Boolean highlight, CategoryEntity category, CitiesEntity cities, Set<ImagesEntity> images, Set<BookingEntity> bookings, Set<CarCaracteristicEntity> carCaracteristic) {
        this.id = id;
        this.nameCar = nameCar;
        this.descritpion = descritpion;
        this.price = price;
        this.year = year;
        this.highlight = highlight;
        this.category = category;
        this.cities = cities;
        this.images = images;
        this.bookings = bookings;
        this.carCaracteristic = carCaracteristic;
    }

    public CarEntity(InputCarDto car) {
        this.nameCar = car.getNameCar();
        this.descritpion = car.getDescritpion();
        this.price = car.getPrice();
        this.year = car.getYear();
        this.highlight = car.getHighlight();
        this.category = new CategoryEntity();
        this.category.setId(car.getIdCategory());
        this.cities = new CitiesEntity();
        this.cities.setId(car.getIdCity());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public CitiesEntity getCities() {
        return cities;
    }

    public void setCities(CitiesEntity cities) {
        this.cities = cities;
    }

    public Set<ImagesEntity> getImages() {
        return images;
    }

    public void setImages(Set<ImagesEntity> images) {
        this.images = images;
    }

    public Set<BookingEntity> getBookings() {
        return bookings;
    }

    public void setBookings(Set<BookingEntity> bookings) {
        this.bookings = bookings;
    }

    public Set<CarCaracteristicEntity> getCarCaracteristic() {
        return carCaracteristic;
    }

    public void setCarCaracteristic(Set<CarCaracteristicEntity> carCaracteristic) {
        this.carCaracteristic = carCaracteristic;
    }
}
