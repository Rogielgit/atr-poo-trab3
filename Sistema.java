import java.util.*;
import java.util.stream.*;

public class Sistema
{
	private GregorianCalendar dataAtual;
	private List<Usuario> todosUsuarios;
	private List<Livro> todosLivros;

	//construtor, recebendo a data a ser usada:
	public Sistema(Date data)
	{
		this.dataAtual = new GregorianCalendar();
		this.dataAtual.setTime(data);
		todosLivros = new ArrayList<Livro>();
		todosUsuarios = new ArrayList<Usuario>();
	}

	//Set
	public void setData(Date data)
	{
		this.dataAtual.setTime(data);
	}

	public boolean addUsuario(Usuario user)
	{
		return todosUsuarios.add(user);
	}

}