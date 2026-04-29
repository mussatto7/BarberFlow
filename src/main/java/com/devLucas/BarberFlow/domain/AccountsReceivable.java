package com.devLucas.BarberFlow.domain;

import com.devLucas.BarberFlow.enums.StatusToReceive;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "contas_receber")
public class AccountsReceivable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "appointments_id")
    private Appointments appointments;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private StatusToReceive statusToReceive;

    public AccountsReceivable() {
    }

    public AccountsReceivable(Long id, Appointments appointments, BigDecimal amount, StatusToReceive statusToReceive) {
        this.id = id;
        this.appointments = appointments;
        this.amount = amount;
        this.statusToReceive = statusToReceive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appointments getAppointments() {
        return appointments;
    }

    public void setAppointments(Appointments appointments) {
        this.appointments = appointments;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public StatusToReceive getStatusToReceive() {
        return statusToReceive;
    }

    public void setStatusToReceive(StatusToReceive statusToReceive) {
        this.statusToReceive = statusToReceive;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AccountsReceivable that = (AccountsReceivable) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
