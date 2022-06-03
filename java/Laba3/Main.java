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

public class Main {
	public static void main(String[] args) {
		maket person = new maket( 65131, "Nikitina", "Anastasuy", "y-213","Program", "Osnovu programurovanuy", 4, "Ivanov");
		System.out.println(person.toString());
		}
}
