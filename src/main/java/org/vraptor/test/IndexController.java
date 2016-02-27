package org.vraptor.test;

import javax.inject.Inject;

import org.hibernate.Session;

import com.cristiano.model.Nome;
import com.cristiano.model.TransactionManager;
import com.cristiano.model.User;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

@Controller
public class IndexController {

	@Inject
	private Session session;
	
	@Path("/")
	@TransactionManager
	public void index() {
		User userDetached = new User("novo1", "novo12");
		userDetached.setNome(new Nome("lalalala"));
		session.save(userDetached);
	}
}
