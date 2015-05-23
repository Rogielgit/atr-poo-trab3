import java.util.*;

public abstract class Usuario
{
	protected String nome, endereco, codigo; //Código que identifica unicamente cada usuario
	protected int diasDeEmprestimo, diasDeSuspensao, totalLivrosEmprestados;

	public Usuario(String nome, String endereco, String codigo)
	{
		this.nome = nome;
		this.endereco = endereco;
		this.codigo = codigo;
		this.diasDeSuspensao = 0;  //inicia usuário com nenhum dia de suspensão
		this.totalLivrosEmprestados = 0;
	}

	protected GregorianCalendar quandoDevolver(GregorianCalendar hoje) //retorna data de devolucao de livro emprestado HOJE
	{
		GregorianCalendar devolucao = new GregorianCalendar();
		devolucao.setTime(hoje.getTime());	
		devolucao.add(Calendar.DAY_OF_MONTH, this.diasDeEmprestimo); //acrescenta o tanto de dias de emprestimos à data atual  
		devolucao.set(Calendar.HOUR_OF_DAY, 23); //seta a hora como 23:59:59 para devolver
		devolucao.set(Calendar.MINUTE, 59);
		devolucao.set(Calendar.SECOND, 59);
		if(devolucao.get(Calendar.DAY_OF_WEEK) == 1) //se a devolucao cair no domingo
			devolucao.add(Calendar.DAY_OF_MONTH, 1); //adiciona mais um dia
		return devolucao;
	}

	protected void setSuspensao(int diasDeSuspensao)
	{
		this.diasDeSuspensao = diasDeSuspensao;
	}

	protected void incTotalLivrosEmprestados() //incrementa total de livros emprestados
	{
		this.totalLivrosEmprestados++;
	}

	protected void decTotalLivrosEmprestados() //decrementa total de livros emprestados
	{
		this.totalLivrosEmprestados--;
	}

}

class Aluno extends Usuario
{
	static final int maxLivrosAluno = 4; 
	public Aluno(String nome, String endereco, String codigo)
	{
		super(nome, endereco, codigo);
		this.diasDeEmprestimo = 15;
	}

}

class Professor extends Usuario
{
	static final int maxLivrosProfessor = 6; 
	public Professor(String nome, String endereco, String codigo)
	{
		super(nome, endereco, codigo);
		this.diasDeEmprestimo = 60;
	}

}

class Comunidade extends Usuario
{
	static final int maxLivrosComunidade = 2;
	public Comunidade(String nome, String endereco, String codigo)
	{
		super(nome, endereco, codigo);
		this.diasDeEmprestimo = 15;
	}

}
