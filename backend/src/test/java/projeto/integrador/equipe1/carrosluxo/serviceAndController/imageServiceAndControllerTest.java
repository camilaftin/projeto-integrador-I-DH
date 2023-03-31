package projeto.integrador.equipe1.carrosluxo.serviceAndController;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import projeto.integrador.equipe1.carrosluxo.Controller.ImageController;
import projeto.integrador.equipe1.carrosluxo.Dto.input.image.InputImageDto;
import projeto.integrador.equipe1.carrosluxo.Dto.output.image.OutputImageCreateOrUpdateDto;
import projeto.integrador.equipe1.carrosluxo.Dto.output.image.OutputImageDto;
import projeto.integrador.equipe1.carrosluxo.Dto.output.image.OutputImageReadDto;
import projeto.integrador.equipe1.carrosluxo.Exception.BadRequestException;
import projeto.integrador.equipe1.carrosluxo.Exception.ResourceNotFoundException;
import projeto.integrador.equipe1.carrosluxo.Service.ImageService;
import projeto.integrador.equipe1.carrosluxo.Service.UploadService;

import java.nio.file.Files;
import java.util.List;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class imageServiceAndControllerTest {
    @Autowired
    ImageService imageService;

    @Autowired
    ImageController imageController;

    @Autowired
    UploadService uploadService;

    @Test
    void createValid() {
        Assertions.assertDoesNotThrow(() -> {
            OutputImageCreateOrUpdateDto image = imageService.create(new InputImageDto("Imagem de teste", 1L));
            Assertions.assertEquals(2, image.getId());
        });
    }

    @Test
    void createInvalid() {
        Assertions.assertEquals("{\"title\":null,\"car\":\"Este carro não Existir\"}", Assertions.assertThrows(BadRequestException.class, () -> {
            imageService.create(new InputImageDto("Imagem de teste", 10L));
        }).getMessage());
    }

    @Test
    void readValid() {
        Assertions.assertDoesNotThrow(() -> {
            OutputImageReadDto image = imageService.read(1L);
            Assertions.assertEquals("Imagem de um audi", image.getTitle());
        });
    }

    @Test
    void readInvalid() {
        Assertions.assertEquals("Esta imagem não está registrada!", Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            imageService.read(10L);
        }).getMessage());
    }

    @Test
    void updateValid() {
        Assertions.assertDoesNotThrow(() -> {
            OutputImageCreateOrUpdateDto image = imageService.update(1L, new InputImageDto("Uma imagem de um audi", 1L));
            Assertions.assertEquals("Uma imagem de um audi", image.getTitle());
        });
    }

    @Test
    void updateInvalidIdImage() {
        Assertions.assertEquals("Esta imagem não está registrado!", Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            imageService.update(10L, new InputImageDto("Um imagem de um audi", 1L));
        }).getMessage());
    }

    @Test
    void updateInvalidIdCar() {
        Assertions.assertEquals("{\"title\":null,\"car\":\"Este carro não Existir\"}", Assertions.assertThrows(BadRequestException.class, () -> {
            imageService.update(1L, new InputImageDto("Um imagem de um audi", 10L));
        }).getMessage());
    }

    @Test
    void deleteValid() {
        Assertions.assertDoesNotThrow(() -> {
            ClassPathResource resource = new ClassPathResource("teste.png");
            String filename = "teste.png";
            String contentType = "image/png";
            byte[] content = Files.readAllBytes(resource.getFile().toPath());
            MockMultipartFile file = new MockMultipartFile(filename, filename, contentType, content);
            imageService.upload(1L, file);
            String image = imageService.delete(1L);
            Assertions.assertEquals("Esta imagem foi deletado com sucesso!", image);
        });
    }

    @Test
    void deleteInvalid() {
        Assertions.assertEquals("Esta imagem não está registrado!", Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            imageService.delete(5L);
        }).getMessage());
    }

    @Test
    void serviceAllTest() {
        Assertions.assertDoesNotThrow(() -> {
            List<OutputImageDto> list = imageService.all();
            Assertions.assertEquals(1, list.size());
            Assertions.assertEquals(1, list.get(0).getId());
            Assertions.assertEquals("Imagem de um audi", list.get(0).getTitle());
        });
    }


    @Test
    void uploadInvalid() {
        Assertions.assertEquals("Não existir está imagem!", Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            ClassPathResource resource = new ClassPathResource("teste.png");
            String filename = "teste.png";
            String contentType = "image/png";
            byte[] content = Files.readAllBytes(resource.getFile().toPath());
            MockMultipartFile file = new MockMultipartFile(filename, filename, contentType, content);
            imageService.upload(10L, file);
        }).getMessage());
    }

    @Test
    void uploadValid() {
        Assertions.assertDoesNotThrow(() -> {
            ClassPathResource resource = new ClassPathResource("teste.png");
            String filename = "teste.png";
            String contentType = "image/png";
            byte[] content = Files.readAllBytes(resource.getFile().toPath());
            MockMultipartFile file = new MockMultipartFile(filename, filename, contentType, content);
            OutputImageReadDto image = imageService.upload(1L, file);
            Assertions.assertEquals("/image/ce089b77945c6519ad5d9b4fa408ed55.1.png", image.getUrl());
            image = imageService.upload(1L, file);
            Assertions.assertEquals("/image/ce089b77945c6519ad5d9b4fa408ed55.1.png", image.getUrl());
            uploadService.deleteFile("/image/ce089b77945c6519ad5d9b4fa408ed55.1.png");
        });
    }

    @Test
    void ControllerAllTest() {
        Assertions.assertDoesNotThrow(() -> {
            ResponseEntity<List<OutputImageDto>> response = (ResponseEntity<List<OutputImageDto>>) imageController.all();
            Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
            Assertions.assertEquals(1, response.getBody().get(0).getId());
        });
    }

    @Test
    void controllerCreateTest() {
        Assertions.assertDoesNotThrow(() -> {
            ResponseEntity<OutputImageCreateOrUpdateDto> response = (ResponseEntity<OutputImageCreateOrUpdateDto>) imageController.create(new InputImageDto("Imagem de teste", 1L));
            Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
            Assertions.assertEquals(2, response.getBody().getId());
        });
    }

    @Test
    void controllerReadTest() {
        Assertions.assertDoesNotThrow(() -> {
            ResponseEntity<OutputImageReadDto> response = (ResponseEntity<OutputImageReadDto>) imageController.read(1L);
            Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
            Assertions.assertEquals("Imagem de um audi", response.getBody().getTitle());
        });
    }

    @Test
    void controllerUpdateTest() {
        Assertions.assertDoesNotThrow(() -> {
            ResponseEntity<OutputImageCreateOrUpdateDto> response = (ResponseEntity<OutputImageCreateOrUpdateDto>) imageController.update(1L, new InputImageDto("Lateral de um carro Audi", 1L));
            Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
            Assertions.assertEquals("Lateral de um carro Audi", response.getBody().getTitle());
        });
    }

    @Test
    void controllerDeleteTest() {
        Assertions.assertDoesNotThrow(() -> {
            ResponseEntity<String> response = (ResponseEntity<String>) imageController.delete(1L);
            Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
            Assertions.assertEquals("Esta imagem foi deletado com sucesso!", response.getBody());
        });
    }

    @Test
    void controllerUploadTest() {
        Assertions.assertDoesNotThrow(() -> {
            ClassPathResource resource = new ClassPathResource("teste.png");
            String filename = "teste.png";
            String contentType = "image/png";
            byte[] content = Files.readAllBytes(resource.getFile().toPath());
            MockMultipartFile file = new MockMultipartFile(filename, filename, contentType, content);
            ResponseEntity<OutputImageReadDto> response = (ResponseEntity<OutputImageReadDto>) imageController.upload(1L, file);
            Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
            Assertions.assertEquals("/image/ce089b77945c6519ad5d9b4fa408ed55.1.png", response.getBody().getUrl());
            uploadService.deleteFile("/image/ce089b77945c6519ad5d9b4fa408ed55.1.png");
        });
    }
}
