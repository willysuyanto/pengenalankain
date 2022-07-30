package com.pirman.pengenalankain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.pirman.pengenalankain.database.entities.Kain;

import java.util.List;

public class KainAdapter extends
        RecyclerView.Adapter<KainAdapter.ViewHolder> {

    private static final String TAG = KainAdapter.class.getSimpleName();

    private Context context;
    private List<Kain> list;
    private KainAdapterCallback mAdapterCallback;

    public KainAdapter(Context context, List<Kain> list, KainAdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.mAdapterCallback = adapterCallback;
    }

    public KainAdapter(KainActivity context, Object kains) {
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

        public ViewHolder(View itemView) {
            super(itemView);

        }
    }

    public interface KainAdapterCallback {
        void onRowKainAdapterClicked(int position);
    }
}