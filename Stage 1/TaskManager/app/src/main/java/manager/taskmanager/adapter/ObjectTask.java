package manager.taskmanager.adapter;

import android.os.Parcel;
import android.os.Parcelable;

public class ObjectTask implements Parcelable {
    String denomination;
    String comment;

    public ObjectTask(String denomination, String comment) {
        this.denomination = denomination;
        this.comment = comment;
    }

    private ObjectTask(Parcel in) {
        denomination = in.readString();
        comment = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(denomination);
        dest.writeString(comment);
    }

    public static final Creator<ObjectTask> CREATOR = new Creator<ObjectTask>() {
        @Override
        public ObjectTask createFromParcel(Parcel in) {
            return new ObjectTask(in);
        }

        @Override
        public ObjectTask[] newArray(int size) {
            return new ObjectTask[size];
        }
    };

    public String getDenomination() {
        return denomination;
    }

    public String getComment() {
        return comment;
    }
}
