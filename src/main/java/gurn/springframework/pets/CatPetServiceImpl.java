package gurn.springframework.pets;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile("cat")
//@Service
public class CatPetServiceImpl implements PetService {
    @Override
    public String getPetType() {
        return "Cats Are the Best!";
    }
}
