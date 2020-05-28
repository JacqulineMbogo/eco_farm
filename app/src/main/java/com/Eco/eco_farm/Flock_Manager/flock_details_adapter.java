package com.Eco.eco_farm.Flock_Manager;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Eco.eco_farm.Models.flock_details_model;
import com.Eco.eco_farm.R;

import java.util.List;

public class flock_details_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>   {

    private List<flock_details_model> flockdetails_models;
    private Context mContext;
    private String TAG ="flock_details_adapter";

    public flock_details_adapter (Context context, List<flock_details_model> flockdetailsModels){
        this.flockdetails_models = flockdetailsModels;
        this.mContext = context;

    }

    private class flockDetailsView extends RecyclerView.ViewHolder {

        TextView chick_qty, hen_qty, cocks_qty,flock_name,flock_breed,acquired_date;

        public flockDetailsView (View itemView) {
        super(itemView);


            flock_name = (TextView) itemView.findViewById(R.id.flock_name);
            flock_breed = (TextView) itemView.findViewById(R.id.flock_breed);
            acquired_date = (TextView) itemView.findViewById(R.id.acquired_date);
            chick_qty = (TextView) itemView.findViewById(R.id.chick_qty);
            hen_qty = (TextView) itemView.findViewById(R.id.hen_qty);
            cocks_qty = (TextView) itemView.findViewById(R.id.cock_qty);

        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flock_manager_activity_flock_details_adapter, parent,false);
        Log.e(TAG, "  view created ");
        return new flockDetailsView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        final flock_details_model model =  flockdetails_models.get(position);

        ((flockDetailsView) holder).flock_name.setText("NAME:  " +model.getFlockName());
        ((flockDetailsView) holder).flock_breed.setText("Breed:  " +model.getFlockBreed());
        ((flockDetailsView) holder).acquired_date.setText("Acquired On: " +model.getAcquiredDate());
        ((flockDetailsView) holder).chick_qty.setText(model.getChickQty());
        ((flockDetailsView) holder).hen_qty.setText(model.getHenQty());
        ((flockDetailsView) holder).cocks_qty.setText(model.getCockQty());


    }

    @Override
    public int getItemCount() {
       // return 0;
        return flockdetails_models.size();
    }
}
