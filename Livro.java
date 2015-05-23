import java.util.*;

public abstract class Livro
{
	protected String titulo, autor, assunto, editora;
	protected int ano, exemplar;
	protected GregorianCalendar devolucao; //para registrar a data de devolucao do livro
	protected boolean emprestado;  //flag de emprestado

	public Livro(String titulo, String autor, String assunto, String editora, int ano, int exemplar)
	{	
		this.titulo = titulo;
		this.autor = autor;
		this.assunto = assunto;
		this.editora = editora;
		this.ano = ano;
		this.exemplar = exemplar;
		this.devolucao = null;
		this.emprestado = false;
	}

	//Sets
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;	
	}
	public void setAutor(String autor)
	{
		this.autor = autor;	
	}
	public void setAssunto(String assunto)
	{
		this.assunto = assunto;	
	}
	public void seEditota(String editora)
	{
		this.editora = editora;	
	}
	public void setAutor(int  ano)
	{	
		this.ano = ano;	
	}
	public void setDataDevolucao(Date dataDevolucao)
	{
		this.devolucao = new GregorianCalendar();
		this.devolucao.setTime(dataDevolucao);  //seta a data de devolucao no calendario
		this.emprestado = true;
	}

	//Gets
	public Date getDataDevolucao() //retorna data de devolucao
	{
		return this.devolucao.getTime();
	}

	public void registraDevolucaoLivro()
	{
		this.emprestado = false;
		this.devolucao = null;
	}

}

class LivroTexto extends Livro  //livro texto
{
	public LivroTexto(String titulo, String autor, String assunto, String editora, int ano)
	{
		super(titulo, autor, assunto, editora, ano);
	}
}

class LivroGeral extends Livro  //livro geral
{
	public LivroGeral(String titulo, String autor, String assunto, String editora, int ano)
	{
		super(titulo, autor, assunto, editora, ano);
	}
}