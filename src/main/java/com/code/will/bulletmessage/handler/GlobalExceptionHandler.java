package com.code.will.bulletmessage.handler;

import com.code.will.bulletmessage.dto.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class, Throwable.class})
    @ResponseBody
    public ResponseEntity<CommonResponse> jsonErrorHandler(Exception e) {
        log.error("统一异常处理捕获", e);
        CommonResponse response = new CommonResponse();
        response.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        if (null != e ){
            response.setMessage(e.getMessage());
        } else {
            response.setMessage("服务异常");
        }
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
