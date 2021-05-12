package com.kakadurf.cv4.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscribe")
public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name="subscriber_id", nullable=false)
    private UserEntity subscriber;
    @ManyToOne
    @JoinColumn(name="subscribable_id", nullable=false)
    private UserEntity subscribable;
}
