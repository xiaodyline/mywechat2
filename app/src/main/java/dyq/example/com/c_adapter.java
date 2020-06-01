package dyq.example.com;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import java.util.Map;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class c_adapter extends RecyclerView.Adapter<c_adapter.contactViewHolder> {

    private static final String TAG = c_adapter.class.getSimpleName();

    private Context mcontext;
    private List<Map<String,Object>> mlistdata;

    public c_adapter(Context context) {
        mcontext = context;
    }

    public void initDataList(List<Map<String,Object>> listData) {
        Log.d(TAG, "initDataList: " + listData.size());
        mlistdata = listData;
        notifyDataSetChanged();
    }

    @Override
    public contactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.contact_text,parent,false);
        return new contactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull contactViewHolder holder, int position) {
        Map<String,Object> rec= mlistdata.get(position);  //从适配器取记录
        holder.Name.setText(rec.get("name").toString());
        holder.Tel.setText(rec.get("tel").toString());
    }

    @Override
    public int getItemCount() {
        return mlistdata == null ? 0 : mlistdata.size();
    }

    public class contactViewHolder extends RecyclerView.ViewHolder {
        TextView Name, Tel;

        public contactViewHolder(View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.name);
            Tel = itemView.findViewById(R.id.tel);
        }
    }

}
