package com.eslamwaheed.www.intcoretask.application.dagger;

import android.content.Context;


import com.eslamwaheed.www.intcoretask.application.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }
}
