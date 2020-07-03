
package consumo.api.testeandroid.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class CategoriesService {

    @SerializedName("categories")
    private List<String> categories;

    public List<String> getmCategories() { return categories; }

    public void setmCategories(List<String> mCategories) { this.categories = categories; }
}
