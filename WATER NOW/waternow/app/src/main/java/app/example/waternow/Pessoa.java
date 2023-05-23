package app.example.waternow;

public class Pessoa {
    public String id;
    public String nome;

    public double agua;

    public double getAgua() {
        return agua;
    }

    public void setAgua(double agua) {
        this.agua = agua;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa() {

    }

    public Pessoa(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
