package med.voll.api.domain.consulta;

import jakarta.persistence.*;

import lombok.*;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

import java.time.LocalDateTime;
@Entity(name = "Consulta")
@Table(name = "consultas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private MotivoCancelamento motivoCancelamento;

    public Consulta(Long id, Medico medico, Paciente paciente, LocalDateTime data){
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
        this.status = Status.AGENDADA;
    }

    public Consulta(Medico medico, Paciente paciente, LocalDateTime data){
        this.medico = medico;
        this.paciente = paciente;
        this.data = data;
        this.status = Status.AGENDADA;
    }

    public void cancelar(DadosCancelamentoConsulta dados){
        this.status = Status.CANCELADA;
        this.motivoCancelamento = dados.motivoCancelamento();
    }
}
