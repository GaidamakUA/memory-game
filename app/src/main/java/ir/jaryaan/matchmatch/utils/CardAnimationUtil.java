package ir.jaryaan.matchmatch.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

import ir.jaryaan.matchmatch.entities.Card;
import lombok.Builder;

/**
 * Created by E.Mehranvari on 5/14/2017.
 */
public class CardAnimationUtil {

    private View view;
    private View faceImageView;
    private View backImageView;
    private Card card;

    private int targetX;
    private int targetY;
    private float targetScale;
    private long lastClickTime = 0;

    public CardAnimationUtil(View view, View faceImageView, Card card) {
        this.view = view;
        this.faceImageView = faceImageView;
        this.card = card;
    }

    public void flipCard() {
        if (card.isFaceDown()) {
            flipRight();
        }
    }

    public void flipBackCard() {
        flipLeft();
    }

    public void moveToDeck() {
        view.animate()
                .rotationX(180)
                .setDuration(100)
                .setListener(null);
        view.animate()
                .alpha(0f)
                .setDuration(400);
    }

    private void flipRight() {
        view.animate()
                .rotationYBy(90)
                .setDuration(100)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (faceImageView.getVisibility() == View.GONE) {
                            faceImageView.setVisibility(View.VISIBLE);
                            flipRight();
                        }
                    }
                });
    }

    private void flipLeft() {
        view.animate()
                .rotationYBy(-90)
                .setDuration(100)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (faceImageView.getVisibility() == View.VISIBLE) {
                            faceImageView.setVisibility(View.GONE);
                            flipLeft();
                        }
                    }
                });
    }
}
