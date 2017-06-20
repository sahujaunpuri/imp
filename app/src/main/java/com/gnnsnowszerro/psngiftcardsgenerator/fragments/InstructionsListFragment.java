package com.gnnsnowszerro.psngiftcardsgenerator.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gnnsnowszerro.psngiftcardsgenerator.R;


public class InstructionsListFragment extends Fragment {


    public static InstructionsListFragment newInstance() {
        InstructionsListFragment fragment = new InstructionsListFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            recyclerView.setAdapter(new InstructionsListRecyclerViewAdapter(getResources().getStringArray(R.array.instruction)));
        }
        return view;
    }

    private class InstructionsListRecyclerViewAdapter extends RecyclerView.Adapter<InstructionsListRecyclerViewAdapter.ViewHolder> {

        private final String[] mValues;


        public InstructionsListRecyclerViewAdapter(String[] items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.inctruction_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mDesc.setText(mValues[position]);
        }

        @Override
        public int getItemCount() {
            return mValues.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public final TextView mDesc;

            public ViewHolder(View view) {
                super(view);
                mDesc = (TextView) view.findViewById(R.id.instruction_text);
            }

        }
    }
}
