// package com.pangisha.pangisha_backend.repository;

// import java.util.List;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

// import com.pangisha.pangisha_backend.model.User;

// public interface PostUserImageRepository extends JpaRepository<User, Long> {

// @Query(value = "SELECT A.*,B.*,C.* " +
// // "A.user_id," +
// // "A.first_name," +
// // "A.last_name," +
// // "A.phone_no," +
// // "A.password," +
// // "A.email," +
// // "A.photo_url, " +
// // "B.post_id," +
// // "B.type," +
// // "B.tittle," +
// // "B.description," +
// // "B.price_month," +
// // "B.time_posted," +
// // "B.payeach_time," +
// // "B.verified," +
// // "B.region," +
// // "B.distric," +
// // "B.ward," +
// // "B.street," +
// // "B.house_no," +
// // "C.image_id," +
// // "C.image_url," +
// // "C.image_url1," +
// // "C.image_url2," +
// // "C.image_url3," +
// // "C.image_url4," +
// // "C.image_url5) " +
// "FROM users A " +
// "JOIN posts B ON A.user_id = B.user_id " +
// "JOIN images C ON B.post_id = C.post_id AND C.post_id=B.post_id;",
// nativeQuery = true)

// List<Object[]> interJoineddata();

// }