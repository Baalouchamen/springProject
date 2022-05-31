package com.amen.sports;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.amen.sports.entities.Sport;
import com.amen.sports.entities.Type;
import com.amen.sports.repos.SportRepository;
import com.amen.sports.service.SportService;
@SpringBootTest
class ProduitsApplicationTests {
@Autowired
private SportRepository sportRepository;
@Autowired
private SportService sportService;



@Test
public void testCreateSport() {
//Sport sp = new Sport("PC Dell",new Date(),9);
//sportRepository.save(sp);
}

@Test
public void testFindSport()
{
Sport s = sportRepository.findById(1L).get();

System.out.println(s);
}
@Test
public void testUpdateSport()
{
Sport s = sportRepository.findById(1L).get();
s.setnbrjoueur(5);
sportRepository.save(s);
}

@Test
public void testDeleteSport()
{
sportRepository.deleteById(1L);;
}
@Test
public void testListerTousSports()
{
List<Sport> spt = sportRepository.findAll();
for (Sport s : spt)
{
System.out.println(s);
}

}

@Test
public void testFindByNomProduitContains()
{
Page<Sport> spt = sportService.getAllSportsParPage(0,2);
System.out.println(spt.getSize());
System.out.println(spt.getTotalElements());
System.out.println(spt.getTotalPages());
spt.getContent().forEach(s -> {System.out.println(s.toString());
});
}

@Test
public void findByNomSport()
{
List<Sport> spt = sportRepository.findByNomSport("volly");

for (Sport s : spt)
{
System.out.println(s);
}

}
@Test
public void testFindByNomSportContains ()
{
List<Sport> spt=sportRepository.findByNomSport("volly");

for (Sport s : spt)
{
System.out.println(s);
} }




@Test
public void testfindByType()
{
Type t = new Type();

List<Sport> spt = sportRepository.findByType(t);
for (Sport s : spt)
{
System.out.println(s);
}

}


@Test
public void findByTypeIdT()
{
List<Sport> spt = sportRepository.findByTypeIdT(1L);
for (Sport s : spt)
{
System.out.println(s);
}}

@Test
public void testfindByOrderByNomSportAsc()
{
List<Sport> spt = sportRepository.findByOrderByNomSportAsc();
for (Sport s : spt)
{
System.out.println(s);
}}




}