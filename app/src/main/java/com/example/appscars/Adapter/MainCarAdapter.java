package com.example.appscars.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appscars.Common.Common;
import com.example.appscars.Interface.IRecyclerOnClickListener;
import com.example.appscars.Model.Response.MainCar;
import com.example.appscars.R;
import com.example.appscars.UI.CarListActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainCarAdapter extends RecyclerView.Adapter<MainCarAdapter.MainCarHolder> {

    Context mContext;
    List<MainCar> mainCarList;

    public MainCarAdapter(Context mContext, List<MainCar> mainCarList) {
        this.mContext = mContext;
        this.mainCarList = mainCarList;
    }

    @NonNull
    @Override
    public MainCarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_layout, parent, false);
        return new MainCarHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainCarHolder holder, int position) {
        Picasso.get().load(mainCarList.get(position).getImage()).into(holder.images_main);
        holder.txt_carname.setText(mainCarList.get(position).getDescEn());

        holder.setiRecyclerOnClickListener((view, pos) -> {
            if (mainCarList.get(pos).getDescEn().contains("CARS")) {
                mContext.startActivity(new Intent(mContext, CarListActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mainCarList == null) return 0;
        else return mainCarList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mainCarList.size() == 1) {
            return Common.DEFAULT_COLUMN_COUNT;
        } else {
            if (mainCarList.size() % 2 == 0) {
                return Common.DEFAULT_COLUMN_COUNT;
            } else {
                return (position > 1 && position == mainCarList.size() - 1)
                        ? Common.FULL_WIDTH_COLUMN
                        : Common.DEFAULT_COLUMN_COUNT;
            }
        }
    }

    public class MainCarHolder extends RecyclerView.ViewHolder implements OnClickListener {
        @BindView(R.id.images_main)
        ImageView images_main;
        @BindView(R.id.txt_carname)
        TextView txt_carname;

        IRecyclerOnClickListener iRecyclerOnClickListener;

        public void setiRecyclerOnClickListener(IRecyclerOnClickListener iRecyclerOnClickListener) {
            this.iRecyclerOnClickListener = iRecyclerOnClickListener;
        }

        Unbinder unbinder;

        public MainCarHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            iRecyclerOnClickListener.OnClick(v, getAdapterPosition());
        }
    }
}
