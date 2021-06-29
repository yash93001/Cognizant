package com.springlearn.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,reason = "Employee Not Found")
public class EmployeeNotFoundException extends Exception{

}