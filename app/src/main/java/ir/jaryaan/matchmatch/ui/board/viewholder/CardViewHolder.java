package ir.jaryaan.matchmatch.ui.board.viewholder;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ir.jaryaan.matchmatch.R;
import ir.jaryaan.matchmatch.entities.Card;
import ir.jaryaan.matchmatch.utils.CardAnimationUtil;

/**
 * Created by ehsun on 5/12/2017.
 */

public class CardViewHolder extends RecyclerView.ViewHolder {

    private final int spanNumber;
    @BindView(R.id.face_image_view)
    ImageView faceImageView;
    @BindView(R.id.body_container)
    CardView bodyContainer;

    private Context context;
    private Card card;
    private ViewGroup parent;
    private int cardNumber;
    private CardListener cardListener;
    private CardAnimationUtil animation;
    private long lastClickTime = 0;


    private CardViewHolder(@NonNull View itemView, @NonNull ViewGroup parent, int cardNumber, int spanNumber, @NonNull CardListener cardListener) {
        super(itemView);
        this.context = itemView.getContext().getApplicationContext();
        this.cardListener = cardListener;
        this.parent = parent;
        this.cardNumber = cardNumber;
        this.spanNumber = spanNumber;
        ButterKnife.bind(this, itemView);
        calculateItemSize();

    }

    private void calculateItemSize() {
        int numberOfRows = cardNumber / spanNumber;
        itemView.setLayoutParams(new RelativeLayout.LayoutParams(parent.getWidth() / spanNumber, parent.getHeight() / numberOfRows));
    }


    public void onBindView(@NonNull Card card) {
        this.card = card;

        Picasso.with(context)
                .load(card.getCardImage().getImageUrl())
                .into(faceImageView);

        animation = new CardAnimationUtil(
                bodyContainer,
                faceImageView,
                card);
    }


    @OnClick(R.id.body_container)
    void onMessageBodyClick() {
        if (SystemClock.elapsedRealtime() - lastClickTime < 1500L) {
            return;
        }
        lastClickTime = SystemClock.elapsedRealtime();
        flipCardRight();
        if (cardListener != null) {
            cardListener.onCardClick(card);
        }
    }

    private void flipCardRight() {
        animation.flipCard();
    }

    public void flipCardLeft() {
        animation.flipBackCard();

    }

    public void moveCardToDeck() {
        new CardAnimationUtil(
                bodyContainer,
                faceImageView,
                card).moveToDeck();
    }

    public interface CardListener {
        void onCardClick(@NonNull Card card);
    }

    public static class Builder {
        private ViewGroup parent;
        private CardListener cardListener;
        private int cardNumber;
        private int spanCount;

        @NonNull
        public Builder parent(@NonNull ViewGroup parent) {
            this.parent = parent;
            return this;
        }

        @NonNull
        public Builder cardListener(@NonNull CardListener cardListener) {
            this.cardListener = cardListener;
            return this;
        }

        @NonNull
        public Builder cardNumber(int cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        @NonNull
        public CardViewHolder build() {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.grid_item_card_item, parent, false);
            return new CardViewHolder(view, parent, cardNumber, spanCount, cardListener);
        }

        public Builder spanNumber(int spanCount) {
            this.spanCount = spanCount;
            return this;
        }
    }

}
