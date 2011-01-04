package br.com.exemploseguranca.services;

import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.exemploseguranca.model.Usuario;

@Service("hibernateUserDetailsService")
public class HibernateUserDetailsService extends HibernateDaoSupport implements UserDetailsService  {
	
	@Autowired
	public HibernateUserDetailsService(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(String login) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Usuario.class, "usuario");
		criteria.add(Restrictions.eq("usuario.login", login));
		List resultado = getHibernateTemplate().findByCriteria(criteria);
		if(resultado != null && resultado.size() == 0) {
			throw new UsernameNotFoundException("Usuario nao encontrado!");
	    }	
		return (Usuario)resultado.get(0);
	}

}
