package ref0.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
	public interface PersonListener{
		void onPersonNameChanged();
	}
	
	public Person() {
	
	}
	
	public Person(String name)
	{
		this.setName(name);
	}

	public String getName()
	{
		System.out.println("getName");
		return _name;
	}
	
	public String getClassificacao() {
		return _classificacao;
	}
	
	public void setName(String name)
	{
		System.out.println("setName");
		name = name.replaceAll("[^A-Za-z ]", "").replaceAll("( )+", " ");
		_name = name.substring(0, 1).toUpperCase() + name.substring(1);
		int tamanho = _name.length();
		if (tamanho < 5)
			_classificacao = "curto";
		else if (tamanho < 10)
			_classificacao = "medio";
		else _classificacao = "longo";
		fireOnNameChanged();
	}

	public void addListener(PersonListener l)
	{
		this.listeners.add(l);
	}
	
	public void removeListener(PersonListener l)
	{
		this.listeners.remove(l);
	}
	
	private void fireOnNameChanged() {
		for(PersonListener l:this.listeners)
		{
			l.onPersonNameChanged();
		}
	}
	
	private String _name;
	private String _classificacao;
	private List<PersonListener> listeners = new ArrayList<PersonListener>();
}
