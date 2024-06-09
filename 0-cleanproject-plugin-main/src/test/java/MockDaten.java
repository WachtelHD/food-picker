import org.json.JSONArray;
import org.json.JSONObject;

public class MockDaten {
    
    public static String essenBasisInfoMock() {
        return new JSONObject()
            .put("meals", new JSONArray()
                .put(new JSONObject()
                    .put("idMeal", "1")
                    .put("strMeal", "Pizza")
                    .put("strMealThumb", "img1.png"))
                .put(new JSONObject()
                    .put("idMeal", "2")
                    .put("strMeal", "Pasta")
                    .put("strMealThumb", "img2.png")))
            .toString();
    } 

}
