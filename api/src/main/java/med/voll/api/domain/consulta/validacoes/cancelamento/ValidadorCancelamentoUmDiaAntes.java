package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorCancelamentoUmDiaAntes implements ValidadorCancelamentoConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Override
    public void validar(DadosCancelamentoConsulta dados) {
        var dadosConsulta = consultaRepository.getReferenceById(dados.id());
        var horaAgendada = dadosConsulta.getData();
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora,horaAgendada).toHours();
        System.out.println("Diferença em horas: " + diferencaEmHoras);

        if(diferencaEmHoras < 24){
            throw new ValidacaoException("A consulta só pode ser cancelada com 24 horas de antecedência!");
        }
    }
}
