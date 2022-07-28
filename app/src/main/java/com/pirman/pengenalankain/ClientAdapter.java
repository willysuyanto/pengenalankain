package com.pirman.pengenalankain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pirman.pengenalankain.database.entities.Client;

import java.util.List;

public class ClientAdapter extends
        RecyclerView.Adapter<ClientAdapter.ViewHolder> {

    private static final String TAG = ClientAdapter.class.getSimpleName();

    private Context context;
    private List<ClientAdapter> list;
    private ClientAdapterCallback mAdapterCallback;

    public ClientAdapter(Context context, List<ClientAdapter> list, ClientAdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.mAdapterCallback = adapterCallback;
    }

    public ClientAdapter(ClientActivity clientActivity, List<Client> clients) {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_client,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClientAdapter item = list.get(position);
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

        TextView nama, nohp;
        public ViewHolder(View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.content);
            nohp = itemView.findViewById(R.id.content2);
        }
    }

    public interface ClientAdapterCallback {
        void onRowClientAdapterClicked(int position);
    }
}