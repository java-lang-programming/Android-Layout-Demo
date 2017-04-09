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
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import java_lang_programming.com.android_layout_demo.R;

/**
 * CalendarFragment for BottomSheetBehavior
 */
public class CalendarFragment extends Fragment {
    private static final int COLUMN_NUM = 7;
    private static final String PARAM_YEAR = "year";
    private static final String PARAM_MONTH = "month";

    private GridLayoutManager gridLayoutManager;
    private CalendarFragmentAdapter recyclerViewFragmentAdapter;
    private OnFragmentInteractionListener callback;

    private int year;
    private int month;
    private List<Day> days;
    private boolean isInit = false;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param year  year
     * @param month month
     * @return A new instance of fragment CalendarFragment.
     */
    public static CalendarFragment newInstance(int year, int month) {
        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();
        args.putInt(PARAM_YEAR, year);
        args.putInt(PARAM_MONTH, month);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.year = getArguments().getInt(PARAM_YEAR);
            this.month = getArguments().getInt(PARAM_MONTH);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        days = new CopyOnWriteArrayList<>();

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            gridLayoutManager = new GridLayoutManager(context, COLUMN_NUM);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerViewFragmentAdapter = new CalendarFragmentAdapter(getActivity().getApplicationContext(), days, callback);
            recyclerView.setAdapter(recyclerViewFragmentAdapter);
            RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), gridLayoutManager.getOrientation());
            recyclerView.addItemDecoration(dividerItemDecoration);
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!isInit) {
            init();
            isInit = true;
        }
    }

    /**
     * å
     * データローディング
     */
    public void init() {
        // 日付の数
        for (int i = 1; i < 31; i++) {
            Day day = new Day();
            day.year = 2017;
            day.month = 4;
            day.day = i;
            days.add(day);
        }
        recyclerViewFragmentAdapter.notifyItemRangeInserted(0, days.size());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            callback = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onClickDay(Day day);
    }
}