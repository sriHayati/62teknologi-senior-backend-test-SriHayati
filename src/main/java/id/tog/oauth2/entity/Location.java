package id.tog.oauth2.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import id.tog.oauth2.util.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Where(clause = "deleted IS NULL")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true, value = {"created","updated", "deleted", "hibernate_lazy_initializer"})
@Table(name = "location")
public class Location extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address1;

    private String address2;

    private String address3;

    private String city;

    private String country;

    private String state;

    private String zip_code;


}
