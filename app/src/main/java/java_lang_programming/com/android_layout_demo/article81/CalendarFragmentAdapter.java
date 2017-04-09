/**
 * Copyright (C) 2016 Programming Java Android Development Project
 * Programming Java is
 * <p>
 * http://java-lang-programming.com/
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

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import java_lang_programming.com.android_layout_demo.R;

/**
 * RecyclerView.Adapter for CalendarFragment
 */
public class CalendarFragmentAdapter extends RecyclerView.Adapter<CalendarFragmentAdapter.ViewHolder> {
    public static final String TAG = "CalendarFragmentAdapter";

    private final Context context;
    private final List<Day> menuList;
    private final CalendarFragment.OnFragmentInteractionListener listener;

    public CalendarFragmentAdapter(Context context, List<Day> items, CalendarFragment.OnFragmentInteractionListener listener) {
        this.context = context;
        this.menuList = items;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_calendar_item, parent, false);
        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Day day = menuList.get(position);
        holder.dayView.setText(String.valueOf(day.day));

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.onClickDay(day);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView dayView;
        public int viewType;

        public ViewHolder(View view, int viewType) {
            super(view);
            this.view = view;
            this.viewType = viewType;
            this.dayView = (TextView) view.findViewById(R.id.dayView);
        }
    }
}