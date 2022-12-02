package com.ngthvu.quanlynhanvienproject.entity;

public class Salary {
    private Integer id;
    private Float basicSalary;
    private Float coefficientPay;
    private Float coeficientAllowance;

    public Salary(Integer id, Float basicSalary, Float coefficientPay, Float coeficientAllowance) {
        this.id = id;
        this.basicSalary = basicSalary;
        this.coefficientPay = coefficientPay;
        this.coeficientAllowance = coeficientAllowance;
    }

    public Salary(Float basicSalary, Float coefficientPay, Float coeficientAllowance) {
        this.basicSalary = basicSalary;
        this.coefficientPay = coefficientPay;
        this.coeficientAllowance = coeficientAllowance;
    }

    public Salary() {
        this.id = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Float basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Float getCoefficientPay() {
        return coefficientPay;
    }

    public void setCoefficientPay(Float coefficientPay) {
        this.coefficientPay = coefficientPay;
    }

    public Float getCoeficientAllowance() {
        return coeficientAllowance;
    }

    public void setCoeficientAllowance(Float coeficientAllowance) {
        this.coeficientAllowance = coeficientAllowance;
    }
    public Float getTotalSalary(){
        return basicSalary*(coefficientPay + coeficientAllowance);
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", basicSalary=" + basicSalary +
                ", coefficientPay=" + coefficientPay +
                ", coeficientAllowance=" + coeficientAllowance +
                '}';
    }
}
