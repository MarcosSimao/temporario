package com.api.mspaciente.controller.controllerException;

import com.api.mspaciente.model.Exception.ObjectConflictException;
import com.api.mspaciente.model.Exception.ObjectInternalException;
import com.api.mspaciente.model.Exception.ObjectNotFoundException;
import com.api.mspaciente.model.Exception.StandardErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class PatterbControllerException {

    @ExceptionHandler(ObjectConflictException.class)
    public ResponseEntity<StandardErrorResponse> conflict(ObjectConflictException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        return ResponseEntity.status(status).body(new StandardErrorResponse(LocalDateTime.now(), status.value(),
                e.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardErrorResponse> notFound(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(new StandardErrorResponse(LocalDateTime.now(), status.value(),
                e.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(ObjectInternalException.class)
    public ResponseEntity<StandardErrorResponse> internalError(ObjectInternalException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status).body(new StandardErrorResponse(LocalDateTime.now(), status.value(),
                e.getMessage(), request.getRequestURI()));

    }
}
