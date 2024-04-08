package com.example.trailtrekker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private List<HistoryItem> historyList;

    public HistoryAdapter(List<HistoryItem> historyList) {
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HistoryItem historyItem = historyList.get(position);
        holder.titleTextView.setText(historyItem.getTitle());
        holder.destinationTextView.setText(historyItem.getDestination());
        holder.distanceTextView.setText(historyItem.getDistance());
        holder.caloriesTextView.setText(historyItem.getCalories());
        holder.stepsTextView.setText(historyItem.getSteps());

    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView stepsTextView;
        TextView caloriesTextView;
        TextView destinationTextView;
        TextView distanceTextView;
        TextView titleTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            destinationTextView = itemView.findViewById(R.id.destination_text_view);
            distanceTextView = itemView.findViewById(R.id.distance_text_view);
            caloriesTextView = itemView.findViewById(R.id.calories_text_view);
            stepsTextView = itemView.findViewById(R.id.steps_text_view);
        }
    }
}
