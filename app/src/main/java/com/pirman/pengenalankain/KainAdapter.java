package com.pirman.pengenalankain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pirman.pengenalankain.database.entities.Kain;

import java.util.List;

public class KainAdapter extends
        RecyclerView.Adapter<KainAdapter.ViewHolder> {

    private static final String TAG = KainAdapter.class.getSimpleName();

    private Context context;
    private List<Kain> list;
    private KainAdapterCallback mAdapterCallback;

        public KainAdapter(KainActivity context, Object kains) {
        this.context = context;
        this.list = list;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_kain,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Kain item = list.get(position);
        holder.gambar.setText(item.gambar);
        holder.namaKain.setText(item.namaKain);
        holder.deskripsi.setText(item.deskripsi);
        holder.harga.setText((int) item.harga);
        holder.ketebalan.setText(item.ketebalan);
        holder.tekstur.setText(item.tekstur);
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

        TextView gambar, namaKain, deskripsi, harga, ketebalan, tekstur;
        public ViewHolder(View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.content);
            namaKain = itemView.findViewById(R.id.content);
            deskripsi = itemView.findViewById(R.id.content);
            harga = itemView.findViewById(R.id.content);
            ketebalan = itemView.findViewById(R.id.content);
            tekstur = itemView.findViewById(R.id.content);

        }
    }

    public interface KainAdapterCallback {
        void onRowKainAdapterClicked(int position);
    }
}