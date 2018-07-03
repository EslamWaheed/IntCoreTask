package com.eslamwaheed.www.intcoretask.application;

import com.eslamwaheed.www.intcoretask.apimodels.modelinterfaces.CommentInt;
import com.eslamwaheed.www.intcoretask.apimodels.modelinterfaces.MovieInt;
import com.eslamwaheed.www.intcoretask.apimodels.modelsimplementations.CommentImpl;
import com.eslamwaheed.www.intcoretask.apimodels.modelsimplementations.MovieImpl;
import com.eslamwaheed.www.intcoretask.detailscreen.DetailMVP;
import com.eslamwaheed.www.intcoretask.detailscreen.DetailPresenter;
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

    @Provides
    public MovieInt provideMovieInt() {
        return new MovieImpl();
    }

    @Provides
    public CommentInt provideCommentInt() {
        return new CommentImpl();
    }

    @Provides
    public DetailMVP.Presenter provideDetailPresenter(CommentInt commentInt) {
        return new DetailPresenter(commentInt);
    }
}
