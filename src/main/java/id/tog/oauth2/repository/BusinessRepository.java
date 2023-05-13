package id.tog.oauth2.repository;

import id.tog.oauth2.entity.Business;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BusinessRepository extends PagingAndSortingRepository<Business, Long>, JpaSpecificationExecutor<Business> {
}
