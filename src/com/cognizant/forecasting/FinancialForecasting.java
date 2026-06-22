package com.cognizant.forecasting;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static double calculateFutureValueOptimized(double currentValue, double growthRate, int years,
            Map<Integer, Double> memo) {
        if (years == 0) {
            return currentValue;
        }
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        double result = calculateFutureValueOptimized(currentValue * (1 + growthRate), growthRate, years - 1, memo);
        memo.put(years, result);
        return result;
    }

    public static void main(String[] args) {
        double initialInvestment = 1000.0;
        double annualGrowthRate = 0.05;
        int targetYears = 10;

        double standardResult = calculateFutureValue(initialInvestment, annualGrowthRate, targetYears);
        System.out.println("Standard Recursive Future Value: " + standardResult);

        Map<Integer, Double> memoizationMap = new HashMap<>();
        double optimizedResult = calculateFutureValueOptimized(initialInvestment, annualGrowthRate, targetYears,
                memoizationMap);
        System.out.println("Optimized Memoized Future Value: " + optimizedResult);
    }
}
