package com.amen.sports.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Type {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idT;
private String nomT;
private String descriptionT;
@JsonIgnore
@OneToMany(mappedBy = "type")
private List<Sport> sports;
}

