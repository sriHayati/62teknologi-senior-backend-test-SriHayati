package id.tog.oauth2.controller;


import id.tog.oauth2.entity.Business;
import id.tog.oauth2.repository.BusinessRepository;
import id.tog.oauth2.responseException.BadRequest;
import id.tog.oauth2.util.PageableSpec;
import id.tog.oauth2.util.SpecificationUtils;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/business")
public class BusinessController {

    private final BusinessRepository businessRepository;

    public BusinessController(BusinessRepository businessRepository){
        this.businessRepository=businessRepository;
    }

    @Secured({"ROLE_SUPERADMIN", "ROLE_ADMIN"})
    @GetMapping({"","/"})
    public Page<Business> getAllBusiness(@RequestParam Map<String, String> params){
        PageableSpec<Business> pageableSpec = SpecificationUtils.of(params);
        return businessRepository.findAll(pageableSpec.getSpecification(), pageableSpec.getPageable());
    }

    @Secured({"ROLE_SUPERADMIN", "ROLE_ADMIN"})
    @GetMapping({"/{businessId:[\\d]+}", "/{businessId:[\\d]+}"})
    public Business getByIdBusiness(@PathVariable Long businessId){
        Business business=businessRepository.findById(businessId).orElseThrow(() -> new BadRequest("Business white id not found "));
        return  business;
    }

    @Secured({"ROLE_SUPERADMIN", "ROLE_ADMIN"})
    @PostMapping({"","/"})
    public Business postBusiness(@RequestBody Business newBusiness){

        if(newBusiness.getName().isEmpty()) throw new BadRequest("Business name required");
        if(newBusiness.getAlias().isEmpty()) throw new BadRequest("Alias required");
        if (String.valueOf(newBusiness.getDistance()).isEmpty()) throw new BadRequest(" Distance required");
        if(newBusiness.getImageUrl().isEmpty()) throw new BadRequest("Image Url required");
        if (newBusiness.getPhotoCount() == null) throw new BadRequest("photoCount required");
//        if(newBusiness.getDateOpened().isEmpty()) throw new BadRequest("date Opened required");
//        if(newBusiness.getDateClosed().isEmpty()) throw new BadRequest("date Closed required");
        if(newBusiness.getPhone().isEmpty()) throw new BadRequest("phone required");
        if(newBusiness.getPrice().isEmpty()) throw new BadRequest("price required");
        if (newBusiness.getRating() == null) throw new BadRequest("ratting required");
        if(newBusiness.getUrl().isEmpty()) throw new BadRequest("Url required");
        if (newBusiness.getReviewCount() == null) throw new BadRequest("Review Count required");
        if(newBusiness.getYelpMenuUrl().isEmpty()) throw new BadRequest("Yelp Menu Url required");



        return businessRepository.save(newBusiness);

    }

    @Secured({"ROLE_SUPERADMIN", "ROLE_ADMIN"})
    @PutMapping({"/{businessId:[\\d]+}", "/{businessId:[\\d]+}"})
    public Business putBusiness(@PathVariable Long businessId, @RequestBody Business newBusiness){
        Business business = businessRepository.findById(businessId).orElseThrow(() -> new BadRequest("Business .not.found.id"));
        if(newBusiness.getName() != null) business.setName(newBusiness.getName());
        if(newBusiness.getAlias()!= null) business.setAlias(newBusiness.getAlias());
        if (String.valueOf(newBusiness.getDistance()) != null) business.setDistance(newBusiness.getDistance());
        if(newBusiness.getImageUrl()!= null) business.setImageUrl(newBusiness.getImageUrl());
        if (newBusiness.getPhotoCount() != null) business.setPhotoCount(newBusiness.getPhotoCount());
        if(newBusiness.getDateOpened() != null) business.setDateOpened(newBusiness.getDateOpened());
        if(newBusiness.getDateClosed() != null) business.setDateClosed(newBusiness.getDateClosed());
        if(newBusiness.getPhone() != null) business.setPhone(newBusiness.getPhone());
        if(newBusiness.getPrice()!= null) business.setPrice(newBusiness.getPrice());
        if (newBusiness.getRating() != null) business.setRating(newBusiness.getRating());
        if(newBusiness.getUrl() != null) business.setUrl(newBusiness.getUrl());
        if (newBusiness.getReviewCount() != null) business.setReviewCount(newBusiness.getReviewCount());
        if(newBusiness.getYelpMenuUrl() != null) business.setYelpMenuUrl(newBusiness.getYelpMenuUrl());

        return businessRepository.save(business);
    }

    @Secured({"ROLE_SUPERADMIN", "ROLE_ADMIN"})
    @DeleteMapping({"/{businessId:[\\d]+}", "/{businessId:[\\d]+}"})
    public String deleteBattery(@PathVariable Long businessId, Locale locale){
        Business business = businessRepository.findById(businessId).orElseThrow(() -> new BadRequest("business not.found.id"));
        business.setDeleted(new Date());
        businessRepository.save(business);
        return "{\"success\":true}";
    }

}
