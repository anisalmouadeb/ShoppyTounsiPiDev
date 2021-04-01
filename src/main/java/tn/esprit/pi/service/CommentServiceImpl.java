package tn.esprit.pi.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.stream.events.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.mailjet.client.resource.User;

import tn.esprit.pi.configuration.EmailConfig;
import tn.esprit.pi.entities.Commentary;
import tn.esprit.pi.repository.CommentaryRepository;
import tn.esprit.pi.repository.SauvegardeLDCommentRepository;

public class CommentServiceImpl implements ICommentService {
	
	@Autowired
	CommentaryRepository commentaryRepository;
	
	@Autowired
	UserServiceImpl u;
	
	@Autowired
	EmailConfig emailconfig;

	@Autowired
	SauvegardeLDCommentRepository SauvegardeLDCommentrepository;
	
	
	
	public Commentary addComment (Commentary c , User u ) {
        String comm="";
		List <String> interdit= Arrays.asList("hahah","ahahah"); 
        for (int i= 0; i < interdit.size(); i++)
        {	
        	
		if (c.getDescription().contains(interdit.get(i)))	
		{
		    int nb= interdit.get(i).length(); 
		    for (int j= 0; j < nb ; j++)
		    	{comm= comm+"*";}
			 c.setDescription(c.getDescription().replace(interdit.get(i), comm));
        commentaryRepository.save(c);
        
        return c;
        }
        else 
        commentaryRepository.save(c);
		}
		return c;
	}
	
	
	
	@Override
	@Transactional
	public Commentary updatelikescomment(int commentaryId, int userId) {
		Comment comment = commentaryRepository.findById((long) commentaryId).get();
        User user= u.getUserInfo();
		if (user.getId() == (comment.getUser().getId()))
			{System.out.println("1");
		return comment ;}
		else 
		{
		List<Long> likeusers = (List<Long>) SauvegardeLDCommentrepository.userlikes();
		List<Long> commentlikes = (List<Long>) SauvegardeLDCommentrepository.commentlikes();
		if (likeusers.contains(user.getUserId()) && (commentlikes.contains(comment.getId())))
			{System.out.println("3");
			return comment ;}
		
		
		else 
		{
			
		int nb = comment.getLikesComment();
        int a= nb+1;
        comment.setLikesComment(a);
     // create mail sender
      		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
      		mailSender.setHost(this.emailconfig.getHost());
      		mailSender.setPort(this.emailconfig.getPort());
      		mailSender.setUsername(this.emailconfig.getUsername());
      		mailSender.setPassword(this.emailconfig.getPassword());

      		// create email instance
      		SimpleMailMessage mailMessage = new SimpleMailMessage();
      		mailMessage.setFrom("e-dalel@gmail.com");
      		mailMessage.setTo(comment.getUser().getEmail());
      		mailMessage.setSubject("New like ");
      		mailMessage.setText("new like form " + user.getFirstName() + user.getLastName() + " in your Comment <<" + comment.getComment() +">>" );

      		// send mail
      		mailSender.send(mailMessage);
        
        commentRepository.save(comment);
	    SauvegardeLDComment suc= new SauvegardeLDComment();
	    suc.setUserLDcomment((long)userId);
	    suc.setUsercomment((long)commentId);
	    SauvegardeLDCommentrepository.save(suc);
	 
		return comment;
		}
		
		}
	}
	
	
	
	@Override
	public Commentary updateComment(Commentary c) {
        commentaryRepository.save(c);
		return c;
	}
	
	
	@Override
	public void deleteComment(String id) {
       commentaryRepository.deleteById(Long.parseLong(id));
       
	}
	
	
	
	
	
	
	
	
	
	

}
