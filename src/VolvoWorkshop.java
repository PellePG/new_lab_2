import java.util.ArrayList;
import java.util.List;

public class VolvoWorkshop extends Workshop {

    public VolvoWorkshop(){
        super("VolvoWorkshop", 5, createAcceptedCarTypes());

    }
    private static List<String> createAcceptedCarTypes() {
        List<String> acceptedCarTypes = new ArrayList<>();
        acceptedCarTypes.add("Volvo240");
        return acceptedCarTypes;
    }

}