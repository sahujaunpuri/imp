package com.gnnsnowszerro.psngiftcardsgenerator.fragments;

import android.content.Context;
import android.content.Intent;
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
import com.gnnsnowszerro.psngiftcardsgenerator.activitys.CouponActivity;
import com.gnnsnowszerro.psngiftcardsgenerator.callbacks.ShowCouponListener;
import com.gnnsnowszerro.psngiftcardsgenerator.helpers.DataManager;
import com.gnnsnowszerro.psngiftcardsgenerator.models.Coupon;

import java.util.List;

import static com.gnnsnowszerro.psngiftcardsgenerator.fragments.CouponFragment.COUPON_POSITION;


public class CouponsListFragment extends Fragment implements ShowCouponListener {


    public static CouponsListFragment newInstance() {
        CouponsListFragment fragment = new CouponsListFragment();
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

            recyclerView.setAdapter(new CouponsListRecyclerViewAdapter(DataManager.getInstance().getCoupons(), this));
        }
        return view;
    }


    @Override
    public void showCoupon(int position) {
        Intent intent = new Intent(getContext(), CouponActivity.class);
        intent.putExtra(COUPON_POSITION, position);
        getContext().startActivity(intent);
    }

    private class CouponsListRecyclerViewAdapter extends RecyclerView.Adapter<CouponsListRecyclerViewAdapter.ViewHolder> {

        private final List<Coupon> mValues;
        private final ShowCouponListener mListener;

        public CouponsListRecyclerViewAdapter(List<Coupon> items, ShowCouponListener listener) {
            mValues = items;
            mListener = listener;
        }

        @Override
        public CouponsListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.coupon_item, parent, false);
            return new CouponsListRecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final CouponsListRecyclerViewAdapter.ViewHolder holder, final int position) {

            holder.mCoupon = mValues.get(position);

            holder.mDesc.setText(holder.mCoupon.getDesc());
            holder.mPrice.setText(getString(R.string.coins,holder.mCoupon.getPrice()));
            holder.mLogo.setImageResource(holder.mCoupon.getLogo());

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mListener) {
                        mListener.showCoupon(position);
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
            public final TextView mDesc;
            public final TextView mPrice;
            private ImageView mLogo;

            public Coupon mCoupon;


            public ViewHolder(View view) {
                super(view);
                mView = view;

                mDesc = (TextView) view.findViewById(R.id.desc);
                mPrice = (TextView) view.findViewById(R.id.price);
                mLogo = (ImageView) view.findViewById(R.id.logo);
            }

        }
    }
}
