package com.example.shbae.tddexample;

/**
 * Created by shbae on 2017-11-27.
 */

class BreakfastExpense extends Expense {
    public BreakfastExpense(int amount) {
        super(amount);
    }

    @Override
    boolean isMeal() {
        return true;
    }

    @Override
    boolean isOverage() {
        return amount > 1000;
    }
}
