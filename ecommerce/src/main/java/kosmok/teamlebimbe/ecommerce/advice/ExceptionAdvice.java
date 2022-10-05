package kosmok.teamlebimbe.ecommerce.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kosmok.teamlebimbe.ecommerce.controller.response.BaseResponse;
import kosmok.teamlebimbe.ecommerce.exception.EmailAlredyExistException;
import kosmok.teamlebimbe.ecommerce.exception.UnauthorizedException;
import kosmok.teamlebimbe.ecommerce.exception.UsernameAlredyExistException;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = { EmailAlredyExistException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public BaseResponse handleEmailError(EmailAlredyExistException e) {
        return new BaseResponse(e.getMessage(), null);
    }

    @ExceptionHandler(value = { UsernameAlredyExistException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public BaseResponse handleEmailError(UsernameAlredyExistException  e) {
        return new BaseResponse(e.getMessage(), null);
    }
    
    
    @ExceptionHandler(value = { UnauthorizedException.class })
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public BaseResponse handleEmailError(UnauthorizedException  e) {
        return new BaseResponse(e.getMessage(), null);
    }
    
}
