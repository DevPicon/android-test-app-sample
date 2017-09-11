package pe.devpicon.android.androidtestapplication.test;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import pe.devpicon.android.androidtestapplication.injection.TestRecipeApplication;

public class CustomTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, TestRecipeApplication.class.getName(), context);
    }
}
