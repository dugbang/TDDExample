package com.example.shbae.tddexample;

/**
 * Created by shbae on 2017-11-27.
 */

class CarRentalExpense extends Expense {
    public CarRentalExpense(int amount) {
        super(amount);
    }

    @Override
    boolean isMeal() {
        return false;
    }

    @Override
    boolean isOverage() {
        return false;
    }
}
