package com.ngthvu.quanlynhanvienproject.exception;

public class EmployeeNotFoundException extends Exception{
    // This exception where in the Repository we do not found any Employee with given id or something.
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
