public class RegistroEntrada {
    private Veiculo veiculo;
    private Vaga vaga;
    private int horaEntrada;
    private int minutoEntrada;
    private int horaSaida;
    private int minutoSaida;
    private int duracaoHora;
    private int duracaoMinuto;

    public RegistroEntrada(Veiculo veiculo, Vaga vaga, int horaEntrada, int minutoEntrada) {
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.horaEntrada = horaEntrada;
        this.minutoEntrada = minutoEntrada;
    }

    public void registroSaida(int horaSaida, int minutoSaida) {
        this.horaSaida = horaSaida;
        this.minutoSaida = minutoSaida;
        this.vaga.liberar();
    }

    public int calcularDuracao() {
        int entradaEmMinutos = horaEntrada * 60 + minutoEntrada;
        int saidaEmMinutos = horaSaida * 60 + minutoSaida;
        return saidaEmMinutos - entradaEmMinutos;
    }

    public void Relogio(int horaChegada, int minutoChegada, int horaSaida, int minutoSaida) {
        this.horaEntrada = horaChegada;
        if (horaChegada <= 24) {
            this.minutoEntrada = minutoChegada;
            if (this.minutoEntrada <= 60) {
                this.horaSaida = horaSaida;
                if (horaSaida <= 24) {
                    this.minutoSaida = minutoSaida;
                    if (minutoSaida <= 60) {
                        duracaoHora = this.horaSaida - this.horaEntrada;
                        if (this.horaEntrada > this.horaSaida) {
                            duracaoHora += 24;
                        }
                        duracaoMinuto = this.minutoSaida - this.minutoEntrada;
                        if (this.minutoEntrada > this.minutoSaida) {
                            duracaoMinuto += 60;
                            duracaoHora--;
                        }
                        System.out.println("Duração: " + duracaoHora + " horas e " + duracaoMinuto + " minutos");
                    } else {
                        System.out.println("Minuto Inválido");
                    }
                } else {
                    System.out.println("Hora inválida");
                }
            } else {
                System.out.println("Minuto Inválido");
            }
        } else {
            System.out.println("Hora inválida");
        }
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public int getMinutoEntrada() {
        return minutoEntrada;
    }

    public int getHoraSaida() {
        return horaSaida;
    }

    public int getMinutoSaida() {
        return minutoSaida;
    }
}
