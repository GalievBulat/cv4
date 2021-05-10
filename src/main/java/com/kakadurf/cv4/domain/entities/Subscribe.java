package com.kakadurf.cv4.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "subscribe")
public class Subscribe {
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name="subscriber_id", nullable=false)
    private UserEntity subscriber;
    @ManyToOne
    @JoinColumn(name="subscribable_id", nullable=false)
    private UserEntity subscribable;
}
