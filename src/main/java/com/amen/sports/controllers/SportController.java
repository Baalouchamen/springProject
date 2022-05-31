package com.amen.sports.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amen.sports.entities.Sport;
import com.amen.sports.entities.Type;
import com.amen.sports.service.SportService;

@Controller
public class SportController {
@Autowired
SportService sportService;


@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap) {
	List<Type> types = sportService.getAllTypes();
	Sport s = new Sport();
	Type t = new Type();
	//t = types.get(0); 
	s.setType(t);
	modelMap.addAttribute("types", types);
	modelMap.addAttribute("sport", s);
	modelMap.addAttribute("mode", "new");
	return "formSport";
}


@RequestMapping("/saveSport")
public String saveSport(@Valid Sport sport, BindingResult bindingResult)

{
if (bindingResult.hasErrors()) 
	return "formSport";
sportService.saveSport(sport);
return "redirect:/ListeSports";
}



@RequestMapping("/ListeSports")
public String listeSports(ModelMap modelMap,

@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)

{
List<Type> t = sportService.getAllTypes();
modelMap.addAttribute("types", t);
Page<Sport> spt = sportService.getAllSportsParPage(page, size);
modelMap.addAttribute("sports", spt);

modelMap.addAttribute("pages", new int[spt.getTotalPages()]);

modelMap.addAttribute("currentPage", page);
return "listeSports";
}

@RequestMapping("/supprimerSport")
public String supprimerSport(@RequestParam("id") Long id,

ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)

{
sportService.deleteSportById(id);
Page<Sport> spt = sportService.getAllSportsParPage(page,size);

modelMap.addAttribute("sports", spt);
modelMap.addAttribute("pages", new int[spt.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeSports";
}

@RequestMapping("/modifierSport")
public String editerSport(@RequestParam("id") Long id,ModelMap modelMap)
{
	List<Type> t = sportService.getAllTypes();
	modelMap.addAttribute("types", t);
Sport s= sportService.getSport(id);
modelMap.addAttribute("sport", s);
modelMap.addAttribute("mode", "edit");
return "formSport";
}
@RequestMapping("/updateSport")
public String updateSport(@ModelAttribute("sport") Sport sport,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException

{
//conversion de la date

SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
Date dateCreation = dateformat.parse(String.valueOf(date));
sport.setDateCreation(dateCreation);
sportService.updateSport(sport);
List<Sport> spt = sportService.getAllSports();
modelMap.addAttribute("sports", spt);
return "listeSports";

}

@RequestMapping("/chercher")
public String cherhcer(ModelMap modelMap, 
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size,@RequestParam("type") String nom)
{
	System.out.println(nom);
	Page<Sport> s = sportService.getAllSportsByNomParPage(page, size,nom);
	modelMap.addAttribute("sports", s);
	 modelMap.addAttribute("pages", new int[s.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeSports";

}

@RequestMapping("/chercherType")
public String cherhcerType(ModelMap modelMap, 
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size,@RequestParam("type") Long id)
{
	System.out.println(id);
	List<Type> t = sportService.getAllTypes();
	modelMap.addAttribute("types", t);
	Page<Sport> s = sportService.getAllSportsByTypeParPage(page, size,id);
	modelMap.addAttribute("sports", s);
	 modelMap.addAttribute("pages", new int[s.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeSports";

}

}
