package br.com.developerspills.hrpayroll.dtos;

import java.util.UUID;

public record Worker(UUID uid, String name, double dailyIncome) { }
