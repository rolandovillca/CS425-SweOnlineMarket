package edu.miu.cs.cs425.sweonlinemarketproject.model;

import edu.miu.cs.cs425.sweonlinemarketproject.constant.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String roleType;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
