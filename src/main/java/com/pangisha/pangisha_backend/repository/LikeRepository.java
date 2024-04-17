package com.pangisha.pangisha_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import com.pangisha.pangisha_backend.model.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query(value = "SELECT * FROM likes l WHERE l.post_id=:postid ", nativeQuery = true)
    List<Like> likes(Long postid);

}
// GROUP BY l.user_id HAVING COUNT(*) >1