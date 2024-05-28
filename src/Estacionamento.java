import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Vaga> vagas;
    private List<RegistroEntrada> registros;

    public Estacionamento(int numeroVagasCobertas, int numeroVagasDescobertas) {
        vagas = new ArrayList<>();
        registros = new ArrayList<>();

        for (int i = 0; i < numeroVagasCobertas; i++) {
            vagas.add(new Vaga(1)); // Vaga coberta
        }
        for (int i = 0; i < numeroVagasDescobertas; i++) {
            vagas.add(new Vaga(2)); // Vaga descoberta
        }
    }

    public Vaga encontrarVaga(int tipoVaga) {
        for (Vaga vaga : vagas) {
            if (vaga.getTipoVaga() == tipoVaga && !vaga.Ocupacao()) {
                return vaga;
            }
        }
        return null;
    }

    public RegistroEntrada registrarEntrada(Veiculo veiculo, int tipoVaga, int horaEntrada, int minutoEntrada) {
        Vaga vaga = encontrarVaga(tipoVaga);
        if (vaga != null) {
            vaga.ocupar();
            RegistroEntrada registro = new RegistroEntrada(veiculo, vaga, horaEntrada, minutoEntrada);
            registros.add(registro);
            return registro;
        }
        return null;
    }

    public void registrarSaida(RegistroEntrada registro, int horaSaida, int minutoSaida) {
        registro.registroSaida(horaSaida, minutoSaida);
        Recibo recibo = new Recibo(registro);
        recibo.gerarRecibo();
    }

    public RegistroEntrada encontrarRegistroPorPlaca(String placa) {
        for (RegistroEntrada registro : registros) {
            if (registro.getVeiculo().getPlaca().equals(placa) && registro.getHoraSaida() == 0 && registro.getMinutoSaida() == 0) {
                return registro;
            }
        }
        return null;
    }
}
