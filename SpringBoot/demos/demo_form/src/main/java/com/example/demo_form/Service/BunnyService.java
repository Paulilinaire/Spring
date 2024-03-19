package com.example.demo_form.Service;

import com.example.demo_form.model.Bunny;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BunnyService {

    private final Map<UUID, Bunny> bunnies;

    public BunnyService() {
        bunnies = new HashMap<>();
        // on simule une fake bdd
        Bunny bunny1 = Bunny.builder()
                .id(UUID.randomUUID())
                .name("Bugs Bunny")
                .breed("angore")
                .build();

        Bunny bunny2 = Bunny.builder()
                .id(UUID.randomUUID())
                .name("Roger Rabbit")
                .breed("jersey wooly")
                .build();

        Bunny bunny3 = Bunny.builder()
                .id(UUID.randomUUID())
                .name("Lola Bunny")
                .breed("bélier")
                .build();

        bunnies.put(bunny1.getId(), bunny1);
        bunnies.put(bunny2.getId(), bunny2);
        bunnies.put(bunny3.getId(), bunny3);
    }

    public List<Bunny> getBunnies(){
        return bunnies.values().stream().toList();
    }

    public Bunny getBunnyById(UUID id){
        // return bunnies.values().stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
        // on parcourt liste des bunnies, on transforme en stream pour pouvoir y appliquer des méthodes dont le .filter
        // qui va garder l'id du bunny = à celui qu'on a mit en param et renvoit soit ça, soit un résultat null
        return bunnies.get(id);
    }

    public boolean addBunny(Bunny bunny){
//        Bunny bunnyToAdd = Bunny.builder()
//                .id(UUID.randomUUID())
//                .name(bunny.getName())
//                .breed(bunny.getBreed())
//                .build();
        if (bunny.getId() == null){ // si id est null, cad que l'id n'a pas encore d'id, on peut le set et l'ajouter
            bunny.setId(UUID.randomUUID());
            bunnies.put(bunny.getId(), bunny);
            return true;
        } else
            return false;
    }

    public Bunny getBunnyByName(String name){
        return bunnies.values().stream().filter(b -> b.getName().equals(name)).findFirst().orElse(null);
    }

    public boolean deleteBunny(UUID id) {
        if(id != null && bunnies.containsKey(id)) {
            bunnies.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
