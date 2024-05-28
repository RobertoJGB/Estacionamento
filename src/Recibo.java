public class Recibo {
    private RegistroEntrada registro;
    private double valorPorHoraCarroCoberta = 20.0;
    private double valorPorHoraCarroDescoberta = 15.0;
    private double valorPorHoraMotoCoberta = 15.0;
    private double valorPorHoraMotoDescoberta = 10.0;

    public Recibo(RegistroEntrada registro) {
        this.registro = registro;
    }

    public double calcularValor() {
        int duracao = registro.calcularDuracao();
        double horas = duracao / 60.0;
        int tipoVeiculo = registro.getVeiculo().getTipoVeiculo();
        int tipoVaga = registro.getVaga().getTipoVaga();
        double valor;

        if (tipoVeiculo == 1) { // Carro
            if (tipoVaga == 1) {
                valor = horas * valorPorHoraCarroCoberta;
            } else {
                valor = horas * valorPorHoraCarroDescoberta;
            }
        } else { // Moto
            if (tipoVaga == 1) {
                valor = horas * valorPorHoraMotoCoberta;
            } else {
                valor = horas * valorPorHoraMotoDescoberta;
            }
        }

        return valor;
    }

    public void gerarRecibo() {
        System.out.println("\n---------- RECIBO DE PAGAMENTO ----------");
        System.out.println("CPF do Dono: " + registro.getVeiculo().getCpfDono());
        System.out.println("Placa do Veículo: " + registro.getVeiculo().getPlaca());
        System.out.println("Tipo de Veículo: " + (registro.getVeiculo().getTipoVeiculo() == 1 ? "Carro" : "Moto"));
        System.out.println("Tipo de Vaga: " + (registro.getVaga().getTipoVaga() == 1 ? "Coberta" : "Descoberta"));
        System.out.println("Hora de Entrada: " + registro.getHoraEntrada() + ":" + String.format("%02d", registro.getMinutoEntrada()));
        System.out.println("Hora de Saída: " + registro.getHoraSaida() + ":" + String.format("%02d", registro.getMinutoSaida()));
        registro.Relogio(registro.getHoraEntrada(), registro.getMinutoEntrada(), registro.getHoraSaida(), registro.getMinutoSaida());
        System.out.println("Valor a Pagar: R$ " + String.format("%.2f", calcularValor()));
        System.out.println("-----------------------------------------");
    }
}
