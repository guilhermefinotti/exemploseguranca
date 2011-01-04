package br.com.exemploseguranca.web.controle;

import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;


import org.springframework.stereotype.Controller;

import br.com.exemploseguranca.web.util.FacesUtil;

@Controller("loginMB")
public class LoginMB {
	
	public LoginMB() {	
	}
	
	public String logar() {
		try {
		    RequestDispatcher dispatcher = FacesUtil.getServletRequest().getRequestDispatcher("/j_spring_security_check");
		    dispatcher.forward(FacesUtil.getServletRequest(), FacesUtil.getServletResponse());
		    FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception ex) {
			FacesUtil.exibirMensagemErro(ex.getMessage());
			return null;
		}
	    return null;
	}
	
	public String logout() {
		FacesUtil.exibirMensagemAlerta("Sessão finalizada com sucesso");
		try {
			RequestDispatcher dispatcher = FacesUtil.getServletRequest().getRequestDispatcher("/j_spring_security_logout");
			dispatcher.forward(FacesUtil.getServletRequest(), FacesUtil.getServletResponse());
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception ex) {
			FacesUtil.exibirMensagemErro("Erro ao sair do sistema");
			return null;
		}
		return null;
	}

}
