package com.example.shbae.tddexample;

/**
 * Created by shbae on 2017-11-27.
 */

class DinnerExpense extends Expense {
    public DinnerExpense(int amount) {
        super(amount);
    }

    @Override
    boolean isMeal() {
        return true;
    }

    @Override
    boolean isOverage() {
        return amount > 5000;
    }
}
