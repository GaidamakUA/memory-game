package ir.jaryaan.matchmatch.entities;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by ehsun on 5/20/2017.
 */

@Builder
public class Setting {

    public static final int DIFFICULTY_LEVEL_DEFAULT = 0;
    public static final int DIFFICULTY_LEVEL_EASY = 8;
    public static final int DIFFICULTY_LEVEL_NORMAL = 12;
    public static final int DIFFICULTY_LEVEL_HARD = 20;
    public static final int DIFFICULTY_LEVEL_INSANE = 24;

    @DifficultyLevel
    private int difficultyLevel;
    private String nickname;
    private String cardType;

    @Retention(SOURCE)
    @IntDef({DIFFICULTY_LEVEL_DEFAULT, DIFFICULTY_LEVEL_EASY, DIFFICULTY_LEVEL_NORMAL, DIFFICULTY_LEVEL_HARD, DIFFICULTY_LEVEL_INSANE})
    public @interface DifficultyLevel {
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCardType() {
        return cardType;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
