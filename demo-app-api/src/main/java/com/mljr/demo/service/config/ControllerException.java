package com.mljr.demo.service.config;

import javax.servlet.http.HttpServletRequest;

import com.mljr.demo.bean.ResponseDto;
import com.mljr.demo.bean.constant.Code;
import com.mljr.demo.bean.exp.AlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Created by karl on 2016/6/15 0015.
 * MVC 错误 统一处理
 */
@ControllerAdvice
public class ControllerException {
    private static Logger log = LoggerFactory.getLogger(ControllerException.class);

    @ExceptionHandler(AlertException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Object handleBearException(AlertException e, HttpServletRequest request) {
        log.warn("{} {} {}", request.getMethod(), request.getRequestURI(), e.getMessage());
        return ResponseDto.rsFail(Code.E_400, e.getMessage());
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Object handleException(Exception e, HttpServletRequest request) {
        log.error(request.getMethod() + " " + request.getRequestURI(), e);
        StringBuilder buffer = new StringBuilder(512);
        buffer.append(e.getClass()).append(": ").append(e.getMessage());
        for(StackTraceElement stack : e.getStackTrace()){
            buffer.append("\n\t").append("at ").append(stack.toString());
        }
        return ResponseDto.rsFail(Code.E_500, "服务器内部异常!");
    }

    // ============= spring exception ======================
    @ExceptionHandler({MissingServletRequestParameterException.class, ServletRequestBindingException.class, HttpRequestMethodNotSupportedException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Object handleMissingServletRequestParameterException(Exception e, HttpServletRequest request) {
        log.warn("{} {} {}", request.getMethod(), request.getRequestURI(), e.getMessage());
        return ResponseDto.rsFail(Code.E_400, e.getMessage());
    }


    @ExceptionHandler({HttpMediaTypeNotSupportedException.class, HttpMediaTypeNotAcceptableException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Object handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e, HttpServletRequest request) {
        log.warn("{} {} {}", request.getMethod(), request.getRequestURI(), e.getMessage());
        return ResponseDto.rsFail(Code.E_400, e.getMessage());
    }


    @ExceptionHandler(org.springframework.beans.TypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    Object typeMismatchException(Exception e, HttpServletRequest request) {
        log.warn("{} {} {}", request.getMethod(), request.getRequestURI(), e.getMessage());
        return ResponseDto.rsFail(Code.E_400, "参数类型错误:" + e.getMessage());
    }


}
