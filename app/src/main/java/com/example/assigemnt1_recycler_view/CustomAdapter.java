package com.example.assigemnt1_recycler_view;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private final ArrayList<DataModel> dataSet;
    private final Context context;

    public CustomAdapter(ArrayList<DataModel> dataSet, Context context) {
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
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardrow, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        final DataModel dataModel = dataSet.get(position);
        holder.textViewName.setText(dataModel.getName());
        holder.textViewVersion.setText(dataModel.getShortDesc());
        holder.imageView.setImageResource(dataModel.getImage());

        // Set click listener for the item
        holder.itemView.setOnClickListener(v -> showPopupWithInfo(dataModel));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    private void showPopupWithInfo(DataModel dataModel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Full description");
        String message = "<b>Name:</b> " + dataModel.getName() +
                "<br><b>Number of episodes appeared in:</b> " + dataModel.getEpisodesNum() +
                "<br><b>Description:</b><br>" + dataModel.getDesc();

        builder.setMessage(HtmlCompat.fromHtml(message, HtmlCompat.FROM_HTML_MODE_COMPACT));
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
