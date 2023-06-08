package app.example.waternow.objeto;

public class Usuario {
    public float peso;
    public float altura;
    public String sexo;
    public String id;

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario(float peso, float altura, String sexo, String id) {
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
        this.id = id;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
