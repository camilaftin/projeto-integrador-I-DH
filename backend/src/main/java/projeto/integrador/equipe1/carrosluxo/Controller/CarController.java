package projeto.integrador.equipe1.carrosluxo.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projeto.integrador.equipe1.carrosluxo.Dto.CarDto;
import projeto.integrador.equipe1.carrosluxo.Dto.CategoryDto;
import projeto.integrador.equipe1.carrosluxo.Entity.CarEntity;
import projeto.integrador.equipe1.carrosluxo.Entity.CategoryEntity;
import projeto.integrador.equipe1.carrosluxo.Service.CarService;
import projeto.integrador.equipe1.carrosluxo.Service.CategoryService;

import java.util.List;

@RestController
@Tag(name = "Car", description = "Carros")

public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/car")
    @Operation(summary = "Exibir lista de todas as carros", tags = { "Car" })
    List<CarEntity> all(){
        return carService.all();
    }

    @PostMapping("/car")
    @Operation(summary = "Registrar uma novo carro", tags = { "Car" })
    String create(@RequestBody CarDto carDto) throws Exception {
        return carService.create(carDto);
    }

    @GetMapping("/car/{id}")
    @Operation(summary = "Exibir um carro especifico", tags = { "Car" })
    CarDto read(@PathVariable int id) throws Exception {
        return carService.read(id);
    }

    @PutMapping("/car/{id}")
    @Operation(summary = "Atualizar um carro especificp", tags = { "Car" })
    String update(@PathVariable int id, @RequestBody CarDto carDto) throws Exception {
        return carService.update(id, carDto);
    }

    @DeleteMapping("/car/{id}")
    @Operation(summary = "Remover uma carro especificp", tags = { "Car" })
    String delete(@PathVariable int id) throws Exception {
        return carService.delete(id);
    }
}
