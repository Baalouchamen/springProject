package com.amen.sports;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amen.sports.entities.Sport;
import com.amen.sports.service.SportService;

@SpringBootApplication
public class MiniProjetApplication implements CommandLineRunner {
@Autowired
SportService sportService;
public static void main(String[] args) {
SpringApplication.run(MiniProjetApplication.class, args);
}
//@Override
public void run(String... args) throws Exception {
//sportService.saveSport(new Sport("foot", new Date(), 11));
//sportService.saveSport(new Sport("hand", new Date(), 6));
//sportService.saveSport(new Sport("volly", new Date(), 6));
}
}
