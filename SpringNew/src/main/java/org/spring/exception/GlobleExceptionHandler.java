package org.spring.exception;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

public class GlobleExceptionHandler  {
 /*   private static Logger logger = org.slf4j.LoggerFactory.getLogger(GlobleExceptionHandler.class);*/
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(GlobleExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public @ResponseBody ErrorMessage handleNotAuthorizedException(Exception e) {
        BindException exception=(BindException) e;
        BindingResult result= exception.getBindingResult();
        return new ErrorMessage("9999",result.getFieldError().getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)	
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public @ResponseBody ErrorMessage handleForbiddenException(Exception e) {
        logger.error(e.getMessage(), e);
        MissingServletRequestParameterException exception=(MissingServletRequestParameterException) e;
        return new ErrorMessage("9999",e.getLocalizedMessage());
    }
   
   
   
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)	
   @ExceptionHandler(Exception.class)
   public @ResponseBody ErrorMessage serverError(Exception e) {
       logger.error(e.getMessage(), e);
       return new ErrorMessage("9999",e.getLocalizedMessage());
   }
   
   @ExceptionHandler(NotFoundException.class)
   @ResponseStatus(HttpStatus.NOT_FOUND)
   public @ResponseBody ErrorMessage notFoundError(NotFoundException e) {
	   logger.error(e.getErrorMsg(),e.getErrcode());
	   return  new ErrorMessage(e.getErrcode(),e.getErrorMsg());
   }
   /*
    * 
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataAccessException.class)
    public @ResponseBody ErrorMessage handleDataAccessException(Exception e) {
        logger.warn(e.getMessage(), e);
        return new ErrorMessage("数据访问错误: " + e.getLocalizedMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(HttpAccessException.class)
    public @ResponseBody ErrorMessage handleHttpAccessException(Exception e) {
        logger.warn(e.getMessage(), e);
        return new ErrorMessage("访问外部服务错误: " + e.getLocalizedMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public @ResponseBody ErrorMessage handleException(Exception e) {
        logger.warn(e.getMessage(), e);
        return new ErrorMessage("系统内部错误: " + e.getLocalizedMessage());
    }*/
}