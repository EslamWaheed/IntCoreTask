package com.eslamwaheed.www.intcoretask.application;

import com.eslamwaheed.www.intcoretask.apimodels.modelinterfaces.MovieInt;
import com.eslamwaheed.www.intcoretask.mainscreen.MainMVP;
import com.eslamwaheed.www.intcoretask.mainscreen.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    public MainMVP.Presenter provideMainPresenter(MovieInt movieInt) {
        return new MainPresenter(movieInt);
    }
}
