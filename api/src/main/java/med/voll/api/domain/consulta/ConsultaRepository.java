package med.voll.api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta,Long> {

    @Query("""
            SELECT EXISTS(
            SELECT 1
            FROM Consulta c
            WHERE c.medico.id = :idMedico
            AND c.data = :data
            AND c.status = 'AGENDADA'
            )
            """)
    Boolean existsByMedicoIdAndData(Long idMedico, LocalDateTime data);

    @Query("""
            SELECT EXISTS(
            SELECT 1
            FROM Consulta c
            WHERE c.paciente.id = :idPaciente
            AND c.data BETWEEN :primeiroHorario AND :ultimoHorario
            AND c.status = 'AGENDADA'
            )
            """)
    Boolean existsByPacienteIdAndDataBetween(Long idPaciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
