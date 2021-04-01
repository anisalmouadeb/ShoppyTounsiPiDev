package tn.esprit.pi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.pi.entities.SauvegardeLDComment;

public interface SauvegardeLDCommentRepository extends CrudRepository<SauvegardeLDComment, Long> {
    @Query("select s.userLDcomment "
			+"from SauvegardeLDComment s ")
	public List<Long> userlikes();
    
    @Query("select s.usercomment "
			+"from SauvegardeLDComment s ")
	public List<Long> commentlikes();
	
    @Modifying
    @Query("delete "
			+"from SauvegardeLDComment s "
			+"where s.userLDcomment=:userLDcomment "
			+"and s.usercomment=:usercomment ")
	public void DeleteSauv(@Param("userLDcomment") long LDsubject,@Param("usercomment") long usersubject );
    
    @Modifying
    @Query("delete "
			+"from SauvegardeLDComment s "
			+"where s.usercomment=:usercomment ")
	public void DeleteCommentsauv(@Param("usercomment") long usersubject );
}
