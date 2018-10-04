package com.codecool;


import com.codecool.model.Excavation;
import com.codecool.model.Location;
import com.codecool.model.Mine;
import com.codecool.model.Resource;
import com.codecool.repository.IExcavationRepository;
import com.codecool.repository.ILocationRepository;
import com.codecool.repository.IMineRepository;
import com.codecool.repository.IResourceRepository;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class App {
    private static final Logger log = Logger.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    public static void log(String message) {
        log.info(message);
    }

    @Bean
    public CommandLineRunner demo(ILocationRepository locationRepository, IMineRepository mineRepository, IResourceRepository resourceRepository, IExcavationRepository excavationRepository) {
        return (args) -> {
            Location location = new Location("Sosnowiec", "Najgorsze miasto", "Nikt nie wie");
            Mine mine = new Mine(location, "Sosnowiec Gadarka");
            Resource resource = new Resource("Węgiel Brunatny", "Lipny, ale go sporo", 100000);
            Excavation excavation = new Excavation(mine, resource, 10000);

            locationRepository.save(location);
            mineRepository.save(mine);
            resourceRepository.save(resource);
            excavationRepository.save(excavation);
        };
    }
}
