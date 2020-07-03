package consumo.api.testeandroid.network;

import consumo.api.testeandroid.model.CategoriesService;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ChuckNorrisApi {
    @GET("/categories")
    Observable<CategoriesService> getCategoriaResponse();
}
