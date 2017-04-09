/**
 * Copyright (C) 2016 Programming Java Android Development Project
 * Programming Java is
 * <p>
 * http://java-lang-programming.com/
 * <p>
 * Model Generator version : 1.3.2
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package java_lang_programming.com.android_layout_demo.article81;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Model
 */
public class Day implements Parcelable {
    // id
    public int id;
    // year
    public int year;
    // month
    public int month;
    // day
    public int day;

    public Day() {
    }

    public static final Parcelable.Creator<Day> CREATOR
            = new Parcelable.Creator<Day>() {
        public Day createFromParcel(Parcel in) {
            return new Day(in);
        }

        public Day[] newArray(int size) {
            return new Day[size];
        }
    };

    private Day(Parcel in) {
        id = in.readInt();
        year = in.readInt();
        month = in.readInt();
        day = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(id);
        out.writeInt(year);
        out.writeInt(month);
        out.writeInt(day);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("Day [");
        str.append(" id=" + id);
        str.append(", year=" + year);
        str.append(", month=" + month);
        str.append(", day=" + day);
        str.append("]");
        return str.toString();
    }

    public String getDay() {
        return year + "/" + month + "/" + day;
    }
}
