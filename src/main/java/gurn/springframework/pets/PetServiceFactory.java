package gurn.springframework.pets;

public class PetServiceFactory {
    public PetService getPetService(String petType) {
        switch (petType) {
            case "dog":
                return new DogPetServiceImpl();
            case "cat":
                return new CatPetServiceImpl();
            default:
                return new DogPetServiceImpl();
        }
    }
}
