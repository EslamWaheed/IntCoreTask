package com.eslamwaheed.www.intcoretask.application.dagger;

import com.eslamwaheed.www.intcoretask.application.MainModule;
import com.eslamwaheed.www.intcoretask.mainscreen.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, MainModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);
}
