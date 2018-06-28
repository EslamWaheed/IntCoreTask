package com.eslamwaheed.www.intcoretask.application;

import android.app.Application;

import com.eslamwaheed.www.intcoretask.application.dagger.AppComponent;
import com.eslamwaheed.www.intcoretask.application.dagger.AppModule;
import com.eslamwaheed.www.intcoretask.application.dagger.DaggerAppComponent;

public class App extends Application {
    private AppComponent component;

    public AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .mainModule(new MainModule())
                .build();

    }
}
