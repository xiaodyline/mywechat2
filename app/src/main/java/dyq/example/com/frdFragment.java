package dyq.example.com;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class frdFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    //    define the dataset
    private List<String> list;
    private frd_adapter frd_adapter;


    public frdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.tab02, container, false);
        initData();
        initRecyclerView();
        return view;
    }

    //    initialize the data
    private void initData() {
        Log.d("initdata","list");
        list = new ArrayList<String>();
        list.add("呆橘");
        list.add("壳哥");
        list.add("绒绒");
        list.add("须须");
        list.add("揪揪");
        list.add("炸炸");
        list.add("丸总");
        list.add("贵宇");
        list.add("飒飒");
    }

    //    initialize the recyclerview
    private void initRecyclerView() {
        Log.d("initrv","s");
//        get RecyclerView
        recyclerView = view.findViewById(R.id.recycleview);
////        when we know that changes in content don't change the layout size of the RecyclerView, use this setting to avoid the same calculation to improve performance
//        recyclerView.setHasFixedSize(true);

//        create frd_adapter for recycleview
        frd_adapter = new frd_adapter(getActivity(),list);

//        set frd_adapter for recycleview
        recyclerView.setAdapter(frd_adapter);

//        set the layoutManager to control the effect of display
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

//        set the cut-off rule of item
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

    }


}
