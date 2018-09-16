package com.example.spring_hibernate_validator.controller;

import com.example.spring_hibernate_validator.entity.DemoEntity;

import javax.validation.Valid;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value = "/validator")
public class IndexController {

    @Autowired
    private MessageSource messageSource;

    @PostMapping
    public String validator(@Valid DemoEntity entity, BindingResult result) {
        if (result.hasErrors()) {
            StringBuffer msg = new StringBuffer();

            List<FieldError> fieldErrors = result.getFieldErrors();
            Locale currentLocal = LocaleContextHolder.getLocale();
            for (FieldError fieldError : fieldErrors) {
                val errorMessage = messageSource.getMessage(fieldError, currentLocal);
                msg.append(fieldError.getField() + ":" + errorMessage + ",");
            }
            return  msg.toString();
        }
        return "pass";
    }
}
