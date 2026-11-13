package modelo;



public class SolicitacaoAdocao {

private static int contador = 1;

    private final int id;
    private Voluntario voluntario;
    private Animais animal;
    private String status;

    public SolicitacaoAdocao(Voluntario voluntario, Animais animal) {

        this.id = contador++;
        this.voluntario = voluntario;
        this.animal = animal;
        this.status = "PENDENTE";

    }

    public int getId() {
        return id;
    }

    public Voluntario getVoluntario() {
        return voluntario;
    }

    public Animais getAnimal() {
        return animal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}



