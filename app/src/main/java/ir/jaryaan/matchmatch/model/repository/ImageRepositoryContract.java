package ir.jaryaan.matchmatch.model.repository;

import androidx.annotation.NonNull;

import java.util.List;

import ir.jaryaan.matchmatch.entities.CardImage;
import rx.Observable;

/**
 * Created by ehsun on 5/12/2017.
 */

public interface ImageRepositoryContract {
    @NonNull
    Observable<List<CardImage>> getCardImages(int totalNumber);

}
