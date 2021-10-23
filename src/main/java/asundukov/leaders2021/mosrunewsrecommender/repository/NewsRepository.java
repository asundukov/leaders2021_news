package asundukov.leaders2021.mosrunewsrecommender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsEntity, Integer> {
}
