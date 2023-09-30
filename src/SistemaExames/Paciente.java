package SistemaExames;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Paciente extends Usuario {
    private List<Autorizacao> autorizacoes;

    public Paciente(int id, String nome) {
        super(id, nome, "Paciente");
        this.autorizacoes = new ArrayList<>();
    }

    // Método para listar as autorizações de exame do paciente ordenadas pela data de cadastro
    public List<Autorizacao> listarAutorizacoesPorDataCadastro() {
        return autorizacoes.stream()
                .filter(autorizacao -> autorizacao.getPaciente().equals(this))
                .sorted(Comparator.comparing(Autorizacao::getDataCadastro))
                .collect(Collectors.toList());
    }

    // Método para marcar um exame como realizado e verificar se a ação é permitida
	public boolean marcarExameComoRealizado(Exame exame, String dataRealizacao) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataSolicitacao = exame.getDataSolicitacao();
            Date dataMarcacao = dateFormat.parse(dataRealizacao);

            long diferencaEmMillis = dataMarcacao.getTime() - dataSolicitacao.getTime();
            int diasDecorridos = (int) (diferencaEmMillis / (24 * 60 * 60 * 1000));

            // O paciente pode marcar como realizado antes da data de solicitação ou até 30 dias após
            if (diasDecorridos >= -30 && diasDecorridos <= 0 && !exame.isStatus()) {
                exame.setDataRealizacao(dataRealizacao); // Atualiza a data de realização no Exame
                exame.setStatus(true); // Marca o exame como realizado
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}
