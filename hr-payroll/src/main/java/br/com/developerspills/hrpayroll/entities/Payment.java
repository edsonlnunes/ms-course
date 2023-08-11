package br.com.developerspills.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private String name;
    private double dailyIncome;
    private int days;

    public double getTotal(){
        return days * dailyIncome;
    }
}
