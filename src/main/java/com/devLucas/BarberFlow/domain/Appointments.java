package com.devLucas.BarberFlow.domain;

import com.devLucas.BarberFlow.enums.StatusAppointments;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "agendamentos")
public class Appointments implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private LocalDateTime time;

    @OneToMany(mappedBy = "appointments")
    private List<ItemAppointments> itemAppointments = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private StatusAppointments statusAppointments;

    @OneToOne
    @JoinColumn(name = "accounts_receivable_id")
    private AccountsReceivable accountsReceivable;

    public Appointments() {
    }

    public Appointments(Long id, User user, Client client, LocalDateTime time, List<ItemAppointments> itemAppointments, StatusAppointments statusAppointments, AccountsReceivable accountsReceivable) {
        this.id = id;
        this.user = user;
        this.client = client;
        this.time = time;
        this.itemAppointments = itemAppointments;
        this.statusAppointments = statusAppointments;
        this.accountsReceivable = accountsReceivable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<ItemAppointments> getItemAppointments() {
        return itemAppointments;
    }

    public void setItemAppointments(List<ItemAppointments> itemAppointments) {
        this.itemAppointments = itemAppointments;
    }

    public StatusAppointments getStatusAppointments() {
        return statusAppointments;
    }

    public void setStatusAppointments(StatusAppointments statusAppointments) {
        this.statusAppointments = statusAppointments;
    }

    public AccountsReceivable getAccountsReceivable() {
        return accountsReceivable;
    }

    public void setAccountsReceivable(AccountsReceivable accountsReceivable) {
        this.accountsReceivable = accountsReceivable;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Appointments that = (Appointments) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
