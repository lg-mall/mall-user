package com.practice.mall.user.aop;

import com.practice.mall.user.exception.CheckedException;
import com.practice.mall.user.exception.ResultAssertException;
import com.practice.mall.user.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalControllerExceptionAOP extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Response> handleCheckedException(CheckedException ex, WebRequest request) {
        Response response = new Response(ex.getCode(), ex.getMessage());
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler
    public ResponseEntity<Response> handle(ResultAssertException ex, WebRequest request) {
        Response response = new Response(ex.getCode(), ex.getMessage());
        return ResponseEntity.ok(response);
    }


}
