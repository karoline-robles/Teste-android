package consumo.api.testeandroid.repository;

import consumo.api.testeandroid.model.CategoriesService;
import io.reactivex.Observable;

import static consumo.api.testeandroid.network.ServiceRetrofit.getApiService;

public class ChuckNorrisRepository {
    public Observable<CategoriesService> getCategoriaResponse() {
        return getApiService().getCategoriaResponse(); }
}

