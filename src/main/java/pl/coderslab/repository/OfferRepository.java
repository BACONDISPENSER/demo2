package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Offer;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    List<Offer> findAllByUserId(Long id);

    @Query(value = "SELECT * FROM offer ORDER BY created DESC LIMIT 5", nativeQuery = true)
    List<Offer> findTop5();

    @Query(value = "SELECT * FROM offer ORDER BY created DESC", nativeQuery = true)
    List<Offer> AllAllOffers();






}
