/*
 * Describe the properties, constructor, getters/setters methods, override 
 * the toString() method to output complete information about the object in formatted form:
 * id_studenta
 * fam
 * name
 * group
 * kafedra
 * disciplina
 * mark
 * nameprepod
 */

package src.com.makotogroup.intro;

public class maket {
	private int id_studenta;
	private String fam;
	private String name;
	private String group;
	private String kafedra;
	private String disciplina;
	private int mark;
	private String nameprepod;
	
	
	public maket(int id_studenta, String fam, String name, String group, String kafedra, 
			String disciplina, int mark, String nameprepod) {
	this.id_studenta = id_studenta;
	this.fam = fam;
	this.name = name;
	this.group = group;
	this.kafedra = kafedra;
	this.disciplina = disciplina;
	this.mark = mark;
	this.nameprepod = nameprepod;
	
	}
	
	
	public int getid_studenta() {
	return id_studenta;
	}
	public void setId_studenta(int id_studenta) {
	this.id_studenta = id_studenta;
	}
	public String getfam() {
	return fam;
	}
	public void setFam(String fam) {
	this.fam = fam;
	}
	public String getname() {
	return name;
	}
	public void setname(String name) {
	this.name = name;
	}
	public String getgroup() {
	return group;
	}
	public void setgroup(String group) {
	this.group = group;
	}
	public String getkafedra() {
		return kafedra;
	}
	public void setkafedra(String kafedra) {
		this.kafedra = kafedra;
	}
	public String getdisciplina() {
		return disciplina;
	}
	public void setdisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public int getmark() {
	return mark;
	}
	public void setmark(int mark) {
	this.mark = mark;
	}
	public String getnameprepod() {
		return nameprepod;
	}
	public void setnameprepod(String nameprepod) {
		this.nameprepod = nameprepod;
	}
	
	public String toString()
	{
	 return "Student" + ". Nomer zachetku " + id_studenta + ". Famuliy " + fam + 
	". Name " + name + ". Group " + group + ". Kafedra " + 
	kafedra + ". Disciplina " + disciplina + ". Ocenka " + mark + ". Name prepodavately " + nameprepod + ".";
	}
}
