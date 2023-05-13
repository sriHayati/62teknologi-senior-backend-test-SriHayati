package id.tog.oauth2.repository;

import id.tog.oauth2.entity.Categories;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoriesRepository extends PagingAndSortingRepository<Categories, Long>, JpaSpecificationExecutor<Categories> {
}
