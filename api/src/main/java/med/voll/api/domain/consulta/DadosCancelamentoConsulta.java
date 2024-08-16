package med.voll.api.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(
        @NotNull(message = "O id da consulta é obrigatório")
        Long id,
        @NotNull(message = "O motivo do cancelamento é obrigatório")
        MotivoCancelamento motivoCancelamento) {
}
