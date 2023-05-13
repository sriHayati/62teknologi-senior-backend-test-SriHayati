package id.tog.oauth2.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import id.tog.oauth2.util.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Where(clause = "deleted IS NULL")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true, value = {"created","updated", "deleted", "hibernate_lazy_initializer"})
@Table(name = "business")
public class Business extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alias;

    private Double distance;

    private String imageUrl;

    private Boolean isClaimed;

    private Boolean isClosed;

    private String dateOpened;

    private String dateClosed;

    private String name;

    private String phone;

    private Integer photoCount;

    private String price;

    private Integer rating;

    private Integer reviewCount;

    private String url;

    private String yelpMenuUrl;

    @OneToMany(targetEntity = Categories.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Categories> categories;

    @OneToOne(targetEntity = Coordinates.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Coordinates coordinates;

    @OneToOne(targetEntity = Location.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Location location;

    @OneToMany(targetEntity = PhotoDetails.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PhotoDetails> photoDetails;





//    private String location;
//
//    private Float latitude;
//
//    private Float longitude;
//
//    private String term;
//
//    private Integer radius;
//
//    private String locale;
//
//    private Boolean openNow;
//
//    private Integer openAt;
//
//    private String devicePlatform;
//
//    private String reservationDate;
//
//    private String reservationTime;
//
//    private String reservationCover;



}
