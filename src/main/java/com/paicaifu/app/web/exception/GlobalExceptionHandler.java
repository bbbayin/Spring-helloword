package com.paicaifu.app.web.exception;

import com.paicaifu.app.domain.ErrorInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by bayin on 2017/2/20.
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    public static String ERROR_VIEW_NAME = "error";
    public static final String ERROR_CODE = "0001";
    public static final String ERROR_RESULT = "fail";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURI());
        mav.setViewName(ERROR_VIEW_NAME);
        return mav;
    }

    @ExceptionHandler(value = JsonResultException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request,JsonResultException e) throws Exception {
        ErrorInfo<String> stringErrorInfo = new ErrorInfo<>();
        stringErrorInfo.setCode(ERROR_CODE);
        stringErrorInfo.setMsg("URL:["+request.getRequestURL()+"]");
        stringErrorInfo.setResult(ERROR_RESULT);
        stringErrorInfo.setData(e.toString());
        return stringErrorInfo;
    }
}
