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
//        holder.distanceTextView.setText(historyItem.getDistance());
//        holder.longitudeTextView.setText(historyItem.getLongitude());
//        holder.latitudeTextView.setText(historyItem.getLatitude());
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView destinationTextView;
        TextView distanceTextView;
        TextView titleTextView;
        TextView longitudeTextView;
        TextView latitudeTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            destinationTextView = itemView.findViewById(R.id.destination_text_view);
//            distanceTextView = itemView.findViewById(R.id.distance_text_view);
//            longitudeTextView = itemView.findViewById(R.id.longitude_text_view);
//            latitudeTextView = itemView.findViewById(R.id.latitude_text_view);
        }
    }
}
