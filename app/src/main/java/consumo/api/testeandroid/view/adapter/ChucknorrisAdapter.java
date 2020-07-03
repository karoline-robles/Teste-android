package consumo.api.testeandroid.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import consumo.api.testeandroid.R;
import consumo.api.testeandroid.model.CategoriesService;

public class ChucknorrisAdapter extends RecyclerView.Adapter<ChucknorrisAdapter.ViewHolder> {
    private List<CategoriesService> resultList;

    public ChucknorrisAdapter(List<CategoriesService> resultList) {
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CategoriesService categoriesService = resultList.get(position);
        holder.bind(categoriesService);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public void setUpdate(List<CategoriesService> results) {
        if (this.resultList.isEmpty()){
            this.resultList = results;
        }else {
            this.resultList.addAll(results);
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.txt_card);
        }
        public void bind(CategoriesService result){
            nome.setText(result.getValue());

        }
    }
}