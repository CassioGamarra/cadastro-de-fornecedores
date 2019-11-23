package Model;

/**
 *
 * @author Gnomo
 */
public class Livro {
    private long codigo;
    private String titulo;
    private String resumo;
    private String genero;
    private String autor;
    private int ano;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long id) {
        this.codigo = id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    
}
