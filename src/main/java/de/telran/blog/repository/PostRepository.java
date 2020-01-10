package de.telran.blog.repository;

import de.telran.blog.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/*public interface PostRepository extends PagingAndSortingRepository<PostEntity, Long> {*/
public interface PostRepository extends CrudRepository<PostEntity, Long> {
    @Query("select p from PostEntity p")
    Page<PostEntity> findAllPage(Pageable pageable);

    @Query("select p from PostEntity p")
    Slice<PostEntity> findAllSlice(Pageable pageable);

    @Query("select p from PostEntity p")
    List<PostEntity> findAllSorted(Sort sort);

    Page<PostEntity> findById(Long id, Pageable pageable);
}
