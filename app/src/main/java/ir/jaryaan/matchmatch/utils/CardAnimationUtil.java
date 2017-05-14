package ir.jaryaan.matchmatch.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

import ir.jaryaan.matchmatch.entities.Card;
import lombok.Builder;

/**
 * Created by E.Mehranvari on 5/14/2017.
 */
@Builder
public class CardAnimationUtil {

    private View view;
    private View faceImageView;
    private View backImageView;
    private Card card;


    public void flipCard() {

        if (card.isFaceDown()) {
            flipRight90degree();
        }
    }

    public void undoCard() {
        flipLeft90degree();
    }

    private void flipRight90degree() {

        view.animate()
                .rotationY(90)
                .setDuration(300)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (faceImageView.getVisibility() == View.GONE) {
                            faceImageView.setVisibility(View.VISIBLE);
                            flipRight180degree();
                        } else {
                            flipLeft90degree();
                        }
                    }
                });

    }

    private void flipLeft90degree() {
        view.animate()
                .rotationY(-90)
                .setDuration(300)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (faceImageView.getVisibility() == View.VISIBLE) {
                            faceImageView.setVisibility(View.GONE);
                            flipLeft180degree();
                        } else {
                            flipRight90degree();
                        }
                    }
                });
    }

    private void flipLeft180degree() {
        view.animate()
                .rotationY(-180)
                .setDuration(300)
                .setListener(null);
    }

    private void flipRight180degree() {
        view
                .animate()
                .rotationY(180)
                .setDuration(300)
                .setListener(null);
    }
}
