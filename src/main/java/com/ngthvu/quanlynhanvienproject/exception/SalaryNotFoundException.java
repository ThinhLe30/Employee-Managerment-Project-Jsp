package com.ngthvu.quanlynhanvienproject.exception;

public class SalaryNotFoundException extends Exception{
    // This exception where in the Repository we do not found any Salary with given id or something.
    public SalaryNotFoundException(String message){
        super(message);
    }
}
