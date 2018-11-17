package com.vovroslyakov.chappie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment2 extends Fragment{

	private RecyclerView list;
	private MyAdapter adapter;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

		View rootView = inflater.inflate(R.layout.fragment_1, null);

		list = rootView.findViewById(R.id.rv_list_id);
		LinearLayoutManager lm = new LinearLayoutManager(getActivity());
		list.setLayoutManager(lm);

		adapter = new MyAdapter(30);
		list.setAdapter(adapter);

		return rootView;


	}
}
