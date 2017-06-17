package com.gnnsnowszerro.psngiftcardsgenerator.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gnnsnowszerro.psngiftcardsgenerator.R;
import com.gnnsnowszerro.psngiftcardsgenerator.callbacks.EarnCoinsListener;
import com.gnnsnowszerro.psngiftcardsgenerator.helpers.DataManager;
import com.gnnsnowszerro.psngiftcardsgenerator.models.EarnItem;

import java.util.List;


public class EarnListFragment extends Fragment implements EarnCoinsListener {


    public static EarnListFragment newInstance() {
        EarnListFragment fragment = new EarnListFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_earn_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            recyclerView.setAdapter(new EarnListRecyclerViewAdapter(DataManager.getInstance().getEarnItems(), this));
        }
        return view;
    }


    @Override
    public void earnCoins(int position) {

    }

    public class EarnListRecyclerViewAdapter extends RecyclerView.Adapter<EarnListRecyclerViewAdapter.ViewHolder> {

        private final List<EarnItem> mValues;
        private final EarnCoinsListener mListener;

        public EarnListRecyclerViewAdapter(List<EarnItem> items, EarnCoinsListener listener) {
            mValues = items;
            mListener = listener;
        }

        @Override
        public EarnListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.earn_item, parent, false);
            return new EarnListRecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final EarnListRecyclerViewAdapter.ViewHolder holder, final int position) {

            holder.earnItem = mValues.get(position);

            holder.mTitle.setText(holder.earnItem.getTitle());
            holder.mIcon.setImageResource(holder.earnItem.getIcon());

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {
                        mListener.earnCoins(position);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mTitle;
            public final ImageView mIcon;

            public EarnItem earnItem;


            public ViewHolder(View view) {
                super(view);
                mView = view;

                mTitle = (TextView) view.findViewById(R.id.title);
                mIcon = (ImageView) view.findViewById(R.id.icon);
            }

        }
    }

}
