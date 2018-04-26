package com.brevitaz.errors;

import com.brevitaz.model.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class CenteralizedErrorController
{
    public CenteralizedErrorController() {
    }

    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<ErrorDetail> invalidIdException(InvalidIdException e , WebRequest w)
    {
        ErrorDetail errorDetail = new ErrorDetail(new Date(), e.getMessage(), w.getDescription(false));
        return new ResponseEntity<ErrorDetail>(errorDetail, HttpStatus.NOT_FOUND);
    }

}
