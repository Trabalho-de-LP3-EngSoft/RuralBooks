package br.uffrj.ruralbooks;

public class Obra {
    private String titulo;
    private String autor;
    private String areaEstudo;
    private String dataLancamento;
    private boolean normalizada;

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAreaEstudo() {
        return areaEstudo;
    }

    public void setAreaEstudo(String areaEstudo) {
        this.areaEstudo = areaEstudo;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public boolean isNormalizada() {
        return normalizada;
    }

    public void setNormalizada(boolean normalizada) {
        this.normalizada = normalizada;
    }
}

class Livro extends Obra {
    private String volume;
    private String editora;
    private int numeroPaginas;
    private String isbn;

    // Getters e Setters
    // ...
}

class Artigo extends Obra {
    private String revista;
    private String apendices;

    // Getters e Setters
    // ...
}

class RevistaAcademica extends Obra {
    private String editora;
    private String issn;
    private double mediaCitacoes;

    // Getters e Setters
    // ...
}

class Tese extends Obra {
    private String instituicao;
    private String orientadores;
    private int anoDefesa;

    // Getters e Setters
    // ...
}

