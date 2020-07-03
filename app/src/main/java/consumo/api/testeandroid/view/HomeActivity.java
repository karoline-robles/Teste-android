package consumo.api.testeandroid.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import consumo.api.testeandroid.R;
import consumo.api.testeandroid.model.CategoriesService;
import consumo.api.testeandroid.view.adapter.ChucknorrisAdapter;
import consumo.api.testeandroid.viewmodel.ChuckNorrisViewModel;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ChuckNorrisViewModel chuckNorrisViewModel;
    private List<CategoriesService> categoriaServices = new ArrayList<>();
    private ChucknorrisAdapter adapterChuckNorris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapterChuckNorris);

        chuckNorrisViewModel.getListCharacters();

        chuckNorrisViewModel.listLiveData.observe(this, results -> adapterChuckNorris.setUpdate(results));
    }

    public void initViews(){
        recyclerView = findViewById(R.id.recyclerView);
        chuckNorrisViewModel = ViewModelProviders.of(this).get(ChuckNorrisViewModel.class);
        adapterChuckNorris = new ChucknorrisAdapter(categoriaServices);

    }
}
