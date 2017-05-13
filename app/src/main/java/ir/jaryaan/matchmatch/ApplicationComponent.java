package ir.jaryaan.matchmatch;

import javax.inject.Singleton;

import dagger.Component;
import ir.jaryaan.matchmatch.model.ManagerModule;
import ir.jaryaan.matchmatch.model.source.SourceModule;
import ir.jaryaan.matchmatch.network.NetworkModule;
import ir.jaryaan.matchmatch.ui.PresentersModule;
import ir.jaryaan.matchmatch.ui.board.BoardFragment;
import ir.jaryaan.matchmatch.ui.launch.LaunchActivity;
import ir.jaryaan.matchmatch.ui.main.MainActivity;
import ir.jaryaan.matchmatch.utils.UtilsModule;

/**
 * Created by ehsun on 5/12/2017.
 */

@Singleton
@Component(modules = {
        NetworkModule.class,
        PresentersModule.class,
        SourceModule.class,
        ManagerModule.class,
        UtilsModule.class
})
public interface ApplicationComponent {

    void inject(LaunchActivity activity);

    void inject(MainActivity activity);

    void inject(BoardFragment fragment);
}