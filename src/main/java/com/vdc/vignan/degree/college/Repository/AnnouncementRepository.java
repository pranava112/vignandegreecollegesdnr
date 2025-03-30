// package com.vdc.vignan.degree.college.Repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.vdc.vignan.degree.college.Entity.Announcement;

// @Repository
// public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
// }


package com.vdc.vignan.degree.college.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vdc.vignan.degree.college.Entity.Announcement;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
}
