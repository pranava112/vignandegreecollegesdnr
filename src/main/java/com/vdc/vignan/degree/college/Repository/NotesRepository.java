package com.vdc.vignan.degree.college.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vdc.vignan.degree.college.Entity.Notes;

@Repository
public interface NotesRepository extends JpaRepository<Notes, String> { //  Changed ID type to String
}
