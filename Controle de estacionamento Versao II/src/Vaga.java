public class Vaga {
    private int tipoVaga; // 1 para coberta, 2 para descoberta
    private boolean ocupada;

    public Vaga(int tipoVaga) {
        this.tipoVaga = tipoVaga;
        this.ocupada = false;
    }

    public int getTipoVaga() {
        return tipoVaga;
    }

    public boolean Ocupacao() {
        return ocupada;
    }

    public void ocupar() {
        this.ocupada = true;
    }

    public void liberar() {
        this.ocupada = false;
    }
}
