package com.hotelbook.hotelbook.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.catalina.realm.UserDatabaseRealm.getRoles;

@Entity
@Table(name="Users_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User implements UserDetails {

        @Id
        @SequenceGenerator(name = "sequence_user",allocationSize = 1,sequenceName = "gen_sequence_user")
        @GeneratedValue( strategy = GenerationType.SEQUENCE,generator = "gen_sequence_user")
        private Integer id;
        @Column(name = "role")
        private String role;
        @Column(name = "name")
        private String name;
        @Column(name = "username")
        private String username;
        @Column (name = "Cust_location")
        private String cust_location;
        @Column(name = "Cust_number")
        private Integer Cust_number;
        @Column (name = "password")
        private String password;
        @OneToMany(mappedBy = "user" ,cascade=CascadeType.REMOVE)
        private List<Reservation> resId;
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                List<SimpleGrantedAuthority> userRoles = new ArrayList<>();
                userRoles.add(new SimpleGrantedAuthority(this.getRole()));
                return userRoles;
        }
        @Override
        public String getPassword(){
                return this.password;
        }


        @Override
        public String getUsername() {
                return this.username;
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }
}
