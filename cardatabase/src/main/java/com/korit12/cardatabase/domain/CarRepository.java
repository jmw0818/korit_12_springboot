package com.korit12.cardatabase.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    // CrudRepository에 없는 메서드라면 여기에 정의를 해야 한다.
    // 쿼리는 접두사(findBy)로 시작해야하고, 쿼리에 이용할 엔티티 클래스 필드를 정의해야 한다.

    List<Car> findByBrand(String brand);

    // 색상으로 검색, 그리고 연도로 검색하는 메서드를 직접 정의하시오.
    List<Car> findByColor(String color);
    List<Car> findByModelYear(int modelYear);

    // SQL 상에서의 AND 및 OR 연산자도 적용이 된다.
    // 브랜드와 모델로 자동차 검색
    List<Car> findByBrandAndModel(String brand, String model);

    // 브랜드 또는 색상 별로 자동차 검색
    List<Car> findByBrandOrColor(String brand, String color);

    // 정렬도 가능 - 브랜드로 검색하고, 연도로 정렬
    List<Car> findByBrandOrderByModelYearAsc(String brand);

    // @Query 애너테이션을 이용해서 SQL문 자체를 작성할 수도 있다.
    // 모델명으로 검색
    @Query("select c from Car c where c.model = ?1")
    List<Car> findByModel(String model);
    // 이상의 경우에는 일치하는 것만 구할수가 있는데, @Query를 쓰는 이유는 LIKE 연산자가 사용 가능하기 때문이다.

    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndWith(String brand);

    // 다만 @Query를 쓰게 되면 다른 데이터베이스로의 이식성이 조금 떨어진다.

}
