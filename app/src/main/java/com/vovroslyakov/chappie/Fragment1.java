package com.vovroslyakov.chappie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment implements OnRecyclerViewItemClickListener {
    private RecyclerView list;
    private MyAdapter adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_1, null);

        list = rootView.findViewById(R.id.rv_list_id);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        list.setLayoutManager(lm);

        List<Ekart> products = new ArrayList<>(10);

        products.add(new Ekart("тележка"));
        products.add(new Ekart("повозка"));
        products.add(new Ekart("образец"));


        adapter = new MyAdapter(products);
        list.setAdapter(adapter);


        return rootView;
    }

    @Override
    public void onClick() {

    }
}
