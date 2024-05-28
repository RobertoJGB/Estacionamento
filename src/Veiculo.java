public class Veiculo {
    private String placa;
    private String cpfDono;
    private int tipoVeiculo; // 1 para carro, 2 para moto

    public Veiculo(String placa, String cpfDono, int tipoVeiculo) {
        this.placa = placa;
        this.cpfDono = cpfDono;
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCpfDono() {
        return cpfDono;
    }

    public int getTipoVeiculo() {
        return tipoVeiculo;
    }
}
