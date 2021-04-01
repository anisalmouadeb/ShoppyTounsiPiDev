package tn.esprit.pi.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import antlr.collections.List;
import tn.esprit.pi.entities.Commentary;

public interface CommentaryRepository extends CrudRepository<Commentary, Long> {
	@Query("select c.description, c.date "
			+"from Commentary c "
			+"where c.post.postId=:id "
			+"order by date DESC ")
	public List RecentCommentary(@Param("id") long postId);
	
	@Query("select c.description, c.date, c.nbLikes, c.nbDislikes "
			+"from Commentary c "
			+"where c.post.postId.id=:id "
			+"order by nbLikes DESC ")
	public List pertComment(@Param("id") long postId);

}
