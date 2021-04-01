package tn.esprit.pi.service;

import java.util.List;

import tn.esprit.pi.entities.Commentary;


public interface ICommentService {
	public List<Commentary> retrieveAllComment();
	public Commentary addComment(Commentary c);
	public void deleteComment(String id);
	public Commentary updateComment(Commentary c);
	void affecterCommentAuser(long commentaryId, long userId);
	public List<String> RecentComment(long postId);
	public List<String> persComment(long postId);
	public Commentary updatelikescomment(long commentaryId, long userId);
	public Commentary updatedislikescomment(long commentaryId, long userId);
	public void deleteDislikesComment(long commentaryId, long userId);
	public void deletelikesComment(long  commentaryId,long userId);

}
