package consumo.api.testeandroid.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import consumo.api.testeandroid.model.CategoriesService;
import consumo.api.testeandroid.repository.ChuckNorrisRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ChuckNorrisViewModel extends ViewModel {
        private MutableLiveData<List<CategoriesService>> listMutableLiveData = new MutableLiveData<>();
        public LiveData<List<CategoriesService>> listLiveData = listMutableLiveData;
        private CompositeDisposable disposable = new CompositeDisposable();
        private ChuckNorrisRepository respository = new ChuckNorrisRepository();

        public void getListCharacters() {
            disposable.add(
                    respository.getCategoriaResponse()
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(sportResponse -> listMutableLiveData.setValue(sportResponse.getmCategories()),
                                    throwable -> Log.i("LOG", "MESSAGE -> " + throwable.getMessage()))
            );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
