// package com.vdc.vignan.degree.college.Service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import com.vdc.vignan.degree.college.Entity.Announcement;
// import com.vdc.vignan.degree.college.Repository.AnnouncementRepository;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class AnnouncementService {

//     @Autowired
//     private AnnouncementRepository announcementRepository;

//     // ✅ Create Announcement
//     public Announcement createAnnouncement(Announcement announcement) {
//         return announcementRepository.save(announcement);
//     }

//     // ✅ Get All Announcements
//     public List<Announcement> getAllAnnouncements() {
//         return announcementRepository.findAll();
//     }

//     // ✅ Get Announcement By ID
//     public Optional<Announcement> getAnnouncementById(int id) {
//         return announcementRepository.findById(id);
//     }

 

//     public Announcement updateAnnouncement(int id, Announcement updatedAnnouncement) {
//         return announcementRepository.findById(id)
//             .map(existingAnnouncement -> {
//                 existingAnnouncement.setInformation(updatedAnnouncement.getInformation());
//                 // Log before saving to check values
//                 System.out.println("Updating announcement with ID: " + id + ", New Info: " + updatedAnnouncement.getInformation());
//                 return announcementRepository.save(existingAnnouncement);
//             })
//             .orElse(null); // Return null if ID is not found
//     }
    

//     //  Delete Announcement
//     public boolean deleteAnnouncement(int id) {
//         if (announcementRepository.existsById(id)) {
//             announcementRepository.deleteById(id);
//             return true;
//         }
//         return false;
//     }
// }




package com.vdc.vignan.degree.college.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vdc.vignan.degree.college.Entity.Announcement;
import com.vdc.vignan.degree.college.Repository.AnnouncementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementRepository announcementRepository;

    public Announcement createAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    public Optional<Announcement> getAnnouncementById(int id) {
        return announcementRepository.findById(id);
    }

    public Announcement updateAnnouncement(int id, Announcement updatedAnnouncement) {
        return announcementRepository.findById(id)
            .map(existing -> {
                existing.setInformation(updatedAnnouncement.getInformation());
                return announcementRepository.save(existing);
            }).orElse(null);
    }

    public boolean deleteAnnouncement(int id) {
        if (announcementRepository.existsById(id)) {
            announcementRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
