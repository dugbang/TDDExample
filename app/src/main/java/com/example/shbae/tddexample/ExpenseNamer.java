package com.example.shbae.tddexample;

import android.support.annotation.NonNull;

/**
 * Created by shbae on 2017-11-27.
 */

interface ExpenseNamer {
    @NonNull
    String getName(Expense expense);
}
