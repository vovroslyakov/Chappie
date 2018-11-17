package com.vovroslyakov.chappie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public OnRecyclerViewItemClickListener myClickListener;
    private int numberItems;
    private static int numberIndexCount;

    public MyAdapter(int numberOfItems) {
        numberItems = numberOfItems;
        numberIndexCount = 0;


    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Context context = viewGroup.getContext();
        int layoutIdForItem = R.layout.list_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForItem, viewGroup, false);

        MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.itemViewIndex.setText("Индекс: " + numberIndexCount);

        numberIndexCount++;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }


    // это обертка для элемента списка
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemViewNumber;
        TextView itemViewIndex;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemViewNumber = itemView.findViewById(R.id.tv_number_item_list_id);
            itemViewIndex = itemView.findViewById(R.id.tv_index_item_list_id);
        }

        void bind(int listNumber) {
            itemViewNumber.setText(String.valueOf("Номер: " + listNumber));
        }
    }
}
