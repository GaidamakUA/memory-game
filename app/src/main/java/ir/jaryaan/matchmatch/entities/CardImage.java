package ir.jaryaan.matchmatch.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by ehsun on 5/12/2017.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class CardImage implements Parcelable {
    private String id;
    @SerializedName("url")
    private String imageUrl;

    protected CardImage(Parcel in) {
        this.id = in.readString();
        this.imageUrl = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.imageUrl);
    }

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public static final Parcelable.Creator<CardImage> CREATOR = new Parcelable.Creator<CardImage>() {
        @Override
        public CardImage createFromParcel(Parcel source) {
            return new CardImage(source);
        }

        @Override
        public CardImage[] newArray(int size) {
            return new CardImage[size];
        }
    };
}
