package com.ABPApp.ws.rest.dao;

import java.util.ArrayList;

import com.ABPApp.ws.rest.vo.VOUsuario;

public class DAOUsuario {
	ArrayList<VOUsuario> base = new ArrayList<VOUsuario>();
	public boolean addUser(VOUsuario user) {
		if(isUser(user)==false) {
			base.add(user);
			return true;
		}
		return false;
	}
	
	public boolean isUser(VOUsuario vo) {
		for (int i = 0; i < base.size(); i++) {
			if (base.get(i).getUsuario() == vo.getUsuario()) {
				return true;
			}
		}
		return false;
	}
	
	public VOUsuario isUserName(String name) {
		for (int i = 0; i < base.size(); i++) {
			if (base.get(i).getUsuario() == name) {
				return base.get(i);
			}
		}
		return null;
	}
	
}
