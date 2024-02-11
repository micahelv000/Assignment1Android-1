package com.example.assigemnt1_recycler_view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {
    private ArrayList<DataModel> dataSet;
    private Context context;

    public CustomeAdapter(ArrayList<DataModel> dataSet, Context context) {
        this.dataSet = dataSet;
        this.context = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewVersion;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView);
            textViewVersion = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public CustomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardrow, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.MyViewHolder holder, int position) {
        final DataModel dataModel = dataSet.get(position);
        holder.textViewName.setText(dataModel.getName());
        holder.textViewVersion.setText(dataModel.getVersion());
        holder.imageView.setImageResource(dataModel.getImage());

        // Set click listener for the item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWithInfo(dataModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    private void showPopupWithInfo(DataModel dataModel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Full description");
        String message = "<b>Name:</b> " + dataModel.getName() +
                "<br><b>Number of Episodes:</b> " + dataModel.getVersion() +
                "<br><b>Description:</b><br>" + dataModel.getDesc();

        builder.setMessage(Html.fromHtml(message));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
