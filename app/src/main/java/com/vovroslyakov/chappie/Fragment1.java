package com.vovroslyakov.chappie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Fragment1 extends Fragment implements OnRecyclerViewItemClickListener {
    private RecyclerView list;
    private MyAdapter adapter;
    private String json;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_1, null);

        list = rootView.findViewById(R.id.rv_list_id);
        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        list.setLayoutManager(lm);

        json = "[\n" +
                "  {\n" +
                "    \"model\":\"телега\",\n" +
                "    \"price\":42.99,\n" +
                "    \"imgUrl\":\"https://www.dropbox.com/s/fhx2npov7fbpdln/blue.png?dl=0\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"model\":\"тачка\",\n" +
                "    \"price\":30.99,\n" +
                "    \"imgUrl\":\"https://www.dropbox.com/s/6h9mjpetk4bdj0h/green.png?dl=0\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"model\":\"повозка\",\n" +
                "    \"price\":20.99,\n" +
                "    \"imgUrl\":\"https://www.dropbox.com/s/d5iu7q3gtcls2nr/orange.png?dl=0\"\n" +
                "  }\n" +
                "]";


        List<ElectricKart> products = new ArrayList<>(10);

        String modelFrom = null;
        Integer priceFrom = 0;
        String imgUrlFrom = null;


        try {
            JSONArray jsonArray = new JSONArray(json);
            JSONObject jsonObjectOne = jsonArray.getJSONObject(0);
            modelFrom = jsonObjectOne.getString("model");
            priceFrom = jsonObjectOne.getInt("price");
            imgUrlFrom = jsonObjectOne.getString("imgUrl");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ElectricKart electricKart = new ElectricKart(modelFrom, priceFrom, imgUrlFrom);

        products.add(electricKart);



        adapter = new MyAdapter(products);
        list.setAdapter(adapter);


        return rootView;
    }

    @Override
    public void onClick() {
    }
}
