package med.voll.api.domain.consulta;

import med.voll.api.domain.consulta.validacoes.cancelamento.ValidadorCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancelamentoDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private List<ValidadorCancelamentoConsulta> validadores;

    public DadosDetalhamentoCancelamentoConsulta cancelar(DadosCancelamentoConsulta dados){
        validadores.forEach(v -> v.validar(dados));

        var dadosConsulta = consultaRepository.getReferenceById(dados.id());
        dadosConsulta.cancelar(dados);
        return new DadosDetalhamentoCancelamentoConsulta(dadosConsulta);
    }
}
