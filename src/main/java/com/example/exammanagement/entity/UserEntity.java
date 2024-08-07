package com.example.exammanagement.entity;


import com.example.exammanagement.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String username;

    @Column(nullable = false)
    String password;

    String email;

    @Enumerated(value = EnumType.STRING)
    Role role;

    @ManyToMany
    @JoinTable(
            name = "users_course",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<UserEntity> users;

    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdDateTime;

    @UpdateTimestamp
    @Column(name = "update_at")
    LocalDateTime updateDateTime;
}
