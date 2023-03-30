package projeto.integrador.equipe1.carrosluxo.Validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import projeto.integrador.equipe1.carrosluxo.Dto.error.ErrorImageDto;
import projeto.integrador.equipe1.carrosluxo.Dto.input.image.InputImageDto;
import projeto.integrador.equipe1.carrosluxo.Exception.BadRequestException;

public class ImageValidation {
    private static final int titleCharactersMinimum = 8;
    private static final int titleCharactersMaximum = 100;

    public ImageValidation() {
    }

    public ImageValidation(InputImageDto image) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String errorTitle = validationText(image.getTitle(), titleCharactersMinimum, titleCharactersMaximum);
        if (!(errorTitle == null)) {
            ErrorImageDto errorImageDto = new ErrorImageDto(errorTitle, null);
            throw new BadRequestException(objectMapper.writeValueAsString(errorImageDto));
        }
    }

    public String validationText(String text, int textCharactersMinimum, int textCharactersMaximum) {
        if (text.trim().isBlank()) {
            return "Este campo não pode está vazio!";
        } else if (text.trim().length() < textCharactersMinimum) {
            return "Este campo dever ser maior do que " + textCharactersMinimum + " caractreres!";
        } else if (text.trim().length() > textCharactersMaximum) {
            return "Este campo dever ser menor do que " + textCharactersMaximum + " caractreres!";
        }
        return null;
    }
}
