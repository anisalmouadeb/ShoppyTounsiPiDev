package tn.esprit.pi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test implements Serializable{

@Id
private long testId;

private String name;
}
