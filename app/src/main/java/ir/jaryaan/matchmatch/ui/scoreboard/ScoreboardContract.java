package ir.jaryaan.matchmatch.ui.scoreboard;

import androidx.annotation.NonNull;

import ir.jaryaan.matchmatch.ui.base.BasePresenterContract;
import ir.jaryaan.matchmatch.ui.base.BaseViewContract;

/**
 * Created by ehsun on 5/22/2017.
 */

public interface ScoreboardContract {
    interface View extends BaseViewContract {

        @NonNull
        String getScoreId();
    }

    interface Presenter extends BasePresenterContract<View> {

    }
}
