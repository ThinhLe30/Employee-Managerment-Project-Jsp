package com.ngthvu.quanlynhanvienproject.exception;

public class DepartmentNotFoundException extends Exception{
    // This exception where in the Repository we do not found any Department with given id or something.
    public DepartmentNotFoundException(String message){
        super(message);
    }
}
