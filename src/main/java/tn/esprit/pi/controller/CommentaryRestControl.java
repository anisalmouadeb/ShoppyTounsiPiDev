package tn.esprit.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.pi.entities.Commentary;
import tn.esprit.pi.service.ICommentService;

public class CommentaryRestControl {
	
	@Autowired
	ICommentService commentService;
	
	// http://localhost:8081/SpringMVC/servlet/retrieve-all-comments
    @GetMapping("/retrieve-all-comments")
	@ResponseBody
	public List<Commentary> getComments() {
	 List<Commentary> list = commentService.retrieveAllComment();
	return list;
    }
    
    /*// http://localhost:8081/SpringMVC/servlet/RecentComment/2
    @GetMapping("/RecentComment/{subject-id}")
	@ResponseBody
	public List<Comment> getComments1(@PathVariable("subject-id") int subjectId) {
	 List<Comment> list = commentService.RecentComment(subjectId);
	return list;
    }  */
    
 // Add comment : http://localhost:8081/SpringMVC/servlet/add-comment
	@PostMapping("/add-comment")
	@ResponseBody
	public Commentary addComment(@RequestBody Commentary c) {
	Commentary comment = commentService.addComment(c);
	return c;
	}
	// http://localhost:8081/SpringMVC/servlet/remove-comment/{comment-id}
	@DeleteMapping("/remove-comment/{comment-id}")
	@ResponseBody
	 public void removeComment(@PathVariable("comment-id") String commentId) {
	 commentService.deleteComment(commentId);
	 }
	
	// http://localhost:8081/SpringMVC/servlet/modify-comment
	@PutMapping("/modify-comment")
	@ResponseBody
	public Commentary modifyComment(@RequestBody Commentary comment) {
	 return commentService.updateComment(comment);
	 }
	// http://localhost:8081/SpringMVC/servlet/updatelikescomment/1/1
    @PutMapping(value = "/updatelikescomment/{idcomment}/{iduser}") 
	public void updatelikescomment(@PathVariable("idcomment")int commentId, @PathVariable("iduser")int userId) {
    	commentService.updatelikescomment(commentId, userId);
	}
    
	// http://localhost:8081/SpringMVC/servlet/updatedislikescomment/1/1
    @PutMapping(value = "/updatedislikescomment/{idcomment}/{iduser}") 
	public void updatedislikescomment(@PathVariable("idcomment")int commentId, @PathVariable("iduser")int userId) {
    	commentService.updatedislikescomment(commentId, userId);
	}
    
 // http://localhost:8081/SpringMVC/servlet/deleteDislikesComment/1/1
    @PutMapping(value = "/deleteDislikesComment/{idcomment}/{iduser}") 
	public void deleteDislikesComment(@PathVariable("idcomment")int commentId, @PathVariable("iduser")int userId) {
    	commentService.deleteDislikesComment(commentId, userId);
	}
    // http://localhost:8081/SpringMVC/servlet/deletelikesComment/1/1
    @PutMapping(value = "/deletelikesComment/{idcomment}/{iduser}") 
	public void deletelikesComment(@PathVariable("idcomment")int commentId, @PathVariable("iduser")int userId) {
    	commentService.deletelikesComment(commentId, userId);
	}
    
	
	// http://localhost:8081/SpringMVC/servlet/affecterCommentAuser/1/2
    @PutMapping(value = "/affecterCommentAuser/{idcomment}/{iduser}") 
	public void affecterCommentAuser(@PathVariable("idcomment")int commentId, @PathVariable("iduser")int userId) {
    	commentService.affecterCommentAuser(commentId, userId);
	}
    
    // URL : http://localhost:8081/SpringMVC/servlet/RecentComment/1
    @GetMapping(value = "RecentComment/{idsubject}")
    @ResponseBody
	public List<String> RecentComment(@PathVariable("idsubject") long subjectId) {

		return commentService.RecentComment(subjectId);
	}
    
    // URL : http://localhost:8081/SpringMVC/servlet/persComment/1
    @GetMapping(value = "persComment/{idsubject}")
    @ResponseBody
	public List<String> persComment(@PathVariable("idsubject") long subjectId) {

		return commentService.persComment(subjectId);
	}

}
