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
@Table(name = "photo_details")
public class PhotoDetails extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String caption;

    private String width;

    private String height;

    private String isUserSubmitted;

    private String label;

    private String userId;
}
