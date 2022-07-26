package com.pirman.pengenalankain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pirman.pengenalankain.database.entities.User;

import java.util.List;

public class PenjahitAdapter extends
        RecyclerView.Adapter<PenjahitAdapter.ViewHolder> {

    private static final String TAG = PenjahitAdapter.class.getSimpleName();

    private Context context;
    private List<User> list;
    private PenjahitAdapterCallback mAdapterCallback;

    public PenjahitAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
//        this.mAdapterCallback = adapterCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_penjahit,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User item = list.get(position);
        holder.nama.setText(item.nama);
        holder.username.setText(item.username);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void clear() {
        int size = this.list.size();
        this.list.clear();
        notifyItemRangeRemoved(0, size);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, username;
        public ViewHolder(View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.content);
            username = itemView.findViewById(R.id.content2);
        }
    }

    public interface PenjahitAdapterCallback {
        void onRowPenjahitAdapterClicked(int position);
    }
}