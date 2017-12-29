package pl.kostrowski.nauka.restapi.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.kostrowski.nauka.restapi.dto.MessageDto;

@RestControllerAdvice
public class ProductAdvice {

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto nullPointerMessage(NullPointerException exception) {
        MessageDto messageDto = new MessageDto("Prosisz o coś czego nie ma :-(", "Error");
        return messageDto;
    }
}
