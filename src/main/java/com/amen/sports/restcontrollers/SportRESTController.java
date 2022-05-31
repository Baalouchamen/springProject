package com.amen.sports.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.amen.sports.entities.Sport;
import com.amen.sports.service.SportService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class SportRESTController {
@Autowired
SportService sportService;
@RequestMapping(method = RequestMethod.GET)
public List<Sport> getAllSports() {
return sportService.getAllSports();
}
}
