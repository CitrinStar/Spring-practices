package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoCancelamentoConsulta(
        Long id,
        Long idMedico,
        Long idPaciente,
        LocalDateTime data,
        Status status,
        MotivoCancelamento motivoCancelamento
) {
    public DadosDetalhamentoCancelamentoConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData(), consulta.getStatus(), consulta.getMotivoCancelamento());
    }
}
